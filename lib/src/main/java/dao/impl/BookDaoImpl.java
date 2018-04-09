package dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import service.impl.AbstractLiBService;
import service.impl.AbstractBookService;

public class BookDaoImpl {
	/**
	 * get the book by id (you can get some books if books have the same id)
	 * 
	 * @param id
	 *            the id of book
	 * @param libServices
	 *            the list lib service
	 * @return this return book(some books) by id
	 */

	public List<AbstractBookService> getBookById(String id, List<AbstractLiBService> libServices) {
		List<AbstractBookService> bookServices = new ArrayList();
		for (AbstractLiBService libService : libServices) {
			IBookDao bookDao = libService.getBookDao();
			bookDao.getBookById(id, libService, bookServices);
		}

		return bookServices;

	}

	/**
	 * implement find command
	 * 
	 * @param author
	 *            the part or full author name
	 * @param nameBook
	 *            the part or full book name
	 * @param libServices
	 *            the list list lib service
	 * @return list book like user request
	 */

	public List<AbstractBook> findCommand(String author, String nameBook, List<AbstractLiBService> libServices) {
		List<AbstractBook> foundBooks = new ArrayList();
		for (AbstractLiBService libService : libServices) {
			IBookDao bookDao = libService.getBookDao();
			bookDao.findCommand(author, nameBook, libService, foundBooks);
		}

		return foundBooks;

	}

	/**
	 * update books
	 * 
	 * @param bookServices
	 * @throws IOException
	 *             some update errors
	 */

	public void update(List<AbstractBookService> bookServices) throws IOException {
		for (AbstractBookService service : bookServices) {
			IBookDao bookDao = service.getBookDao();
			for (AbstractBook book : service.getBooks()) {
				bookDao.update(book);
			}
		}
	}

}
