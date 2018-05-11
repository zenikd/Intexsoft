package dao.factory;

import dao.api.AppSpecificallyBook;
import dao.api.AppSpecificallyLib;
import dao.api.IFactory;
import dao.impl.csv.CsvBookDaoImpl;
import dao.impl.csv.CsvLibDaoImpl;

public class CsvFactory implements IFactory {

	public AppSpecificallyLib getLibDao() {		
		return new CsvLibDaoImpl();
	}

	public AppSpecificallyBook getBookDao() {
		// TODO Auto-generated method stub
		return new CsvBookDaoImpl();
	}
	

}
