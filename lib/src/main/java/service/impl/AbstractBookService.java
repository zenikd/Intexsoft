package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import dao.entity.AbstractLib;

public abstract class AbstractBookService {
	private List<AbstractBook> books = new ArrayList();

	public void addBook(AbstractBook book) {
		books.add(book);
	}

	public void removeBook(AbstractBook book) {
		books.remove(book);

	}

	public List<AbstractBook> getBooks() {
		return books;
	}

	public abstract IBookDao getBookDao();

	public abstract void setBookDao(IBookDao bookDao);
}
