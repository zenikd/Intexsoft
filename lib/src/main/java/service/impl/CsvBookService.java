package service.impl;

import dao.api.IBookDao;
import dao.impl.csv.CsvBookDaoImpl;

public class CsvBookService extends AbstractBookService{
	private IBookDao bookDao = new CsvBookDaoImpl();

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
}
