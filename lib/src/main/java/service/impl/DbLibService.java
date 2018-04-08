package service.impl;

import dao.api.IBookDao;
import dao.impl.db.DbBookDaoImpl;

public class DbLibService extends AbstractLiBService {
	private IBookDao bookDao = new DbBookDaoImpl();

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

}
