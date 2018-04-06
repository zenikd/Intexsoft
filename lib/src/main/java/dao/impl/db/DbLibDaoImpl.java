package dao.impl.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.entity.DbLib;

public class DbLibDaoImpl extends AbstractDaoImpl<DbLib> {

	@Override
	protected DbLib parseRow(ResultSet resultSet) throws SQLException {
		DbLib entity = new DbLib();
		entity.setId(resultSet.getInt("id"));
		entity.setName(resultSet.getString("name"));
		entity.setAdress(resultSet.getString("adress"));

		return entity;
	}

	@Override
	protected String getTableName() {
		return "lib";
	}

}
