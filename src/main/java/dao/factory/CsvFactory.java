package dao.factory;

import dao.api.IBookDao;
import dao.api.ILibDao;
import dao.api.IFactory;
import dao.impl.csv.CsvBookDaoImpl;
import dao.impl.csv.CsvLibDaoImpl;

public class CsvFactory implements IFactory {

	public ILibDao getLibDao() {		
		return new CsvLibDaoImpl();
	}

	public IBookDao getBookDao() {
		// TODO Auto-generated method stub
		return new CsvBookDaoImpl();
	}
	

}
