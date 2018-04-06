package dao.impl.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class PreparedStatemenAction<RETURN_TYPE> {

	private String sql;

	private boolean returnGeneratedKeys;

	public PreparedStatemenAction(String sql) {
		this(sql, false);
	}

	public PreparedStatemenAction(String sql, boolean returnGeneratedKeys) {
		super();
		this.sql = sql;
		this.returnGeneratedKeys = returnGeneratedKeys;
	}

	public boolean isReturnGeneratedKeys() {
		return returnGeneratedKeys;
	}

	public String getSql() {
		return sql;
	}

	public abstract RETURN_TYPE doWithPreparedStatement(PreparedStatement pStmt)
			throws SQLException;
}
