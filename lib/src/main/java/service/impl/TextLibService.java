package service.impl;

import dao.api.IBookDao;
import dao.impl.text.TextBookDaoImpl;

public class TextLibService extends AbstarctLiBService {
	private IBookDao bookDao = new TextBookDaoImpl();

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

}