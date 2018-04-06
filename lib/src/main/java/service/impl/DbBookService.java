package service.impl;

import dao.api.IBookDao;
import dao.impl.db.DbBookDaoImpl;

public class DbBookService extends AbstractBookService {
	private IBookDao bookDao = new DbBookDaoImpl();

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

}
