package service.impl;

import dao.api.IBookDao;
import dao.impl.db.DbBookDaoImpl;

public class DbLibService extends AbstarctLiBService {
	private IBookDao bookDao = new DbBookDaoImpl();

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

}
