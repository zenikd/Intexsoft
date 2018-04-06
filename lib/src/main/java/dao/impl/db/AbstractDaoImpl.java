package dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDaoImpl<ENTITY> {

	private String url = "jdbc:postgresql://localhost:5434/lib";

	private String user = "postgres";

	private String password = "1";

	public ENTITY getById(int id) {
		return executeStatement((statement) -> {
			statement.executeQuery("select * from " + getTableName() + " where id=" + id);

			final ResultSet resultSet = statement.getResultSet();
			final boolean hasNext = resultSet.next();
			ENTITY result = null;
			if (hasNext) {
				result = parseRow(resultSet);
			}

			resultSet.close();
			return result;
		});
	}

	 protected <T> T executeStatement(final StatemenAction<T> action) {
		try (Connection c = getConnection(); Statement stmt = c.createStatement()) {
			c.setAutoCommit(false);
			return action.doWithStatement(stmt);

		} catch (final SQLException e) {
			throw new RuntimeException(e); // wrap catchable exception with
			// runtime
		}

	}

	 protected <T> T executeStatement(final PreparedStatemenAction<T> action) {
		try (Connection c = getConnection();
				PreparedStatement pStmt = action.isReturnGeneratedKeys()
						? c.prepareStatement(action.getSql(), Statement.RETURN_GENERATED_KEYS)
						: c.prepareStatement(action.getSql())) {
			c.setAutoCommit(false);
			try {
				final T doWithPreparedStatement = action.doWithPreparedStatement(pStmt);
				c.commit();
				return doWithPreparedStatement;
			} catch (final Exception e) {
				c.rollback();
				throw new RuntimeException(e);
			}

		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	 protected Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	    }
	 
	

	protected abstract ENTITY parseRow(ResultSet resultSet) throws SQLException;

	protected abstract String getTableName();
}
