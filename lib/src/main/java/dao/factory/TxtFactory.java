package dao.factory;

import dao.api.AppSpecificallyBook;
import dao.api.AppSpecificallyLib;
import dao.api.IFactory;
import dao.impl.txt.TxtBookDaoImpl;
import dao.impl.txt.TxtLibDaoImpl;

public class TxtFactory implements IFactory {

	public AppSpecificallyLib getLibDao() {
		return new TxtLibDaoImpl();
	}

	public AppSpecificallyBook getBookDao() {
		// TODO Auto-generated method stub
		return new TxtBookDaoImpl();
	}

}
