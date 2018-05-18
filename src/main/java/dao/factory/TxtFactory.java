package dao.factory;

import dao.api.IBookDao;
import dao.api.ILibDao;
import dao.api.IFactory;
import dao.impl.txt.TxtBookDaoImpl;
import dao.impl.txt.TxtLibDaoImpl;

public class TxtFactory implements IFactory {

	public ILibDao getLibDao() {
		return new TxtLibDaoImpl();
	}

	public IBookDao getBookDao() {
		// TODO Auto-generated method stub
		return new TxtBookDaoImpl();
	}

}
