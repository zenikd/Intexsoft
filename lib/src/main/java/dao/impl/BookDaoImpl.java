package dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import service.impl.AbstractLiBService;
import service.impl.AbstractBookService;

public class BookDaoImpl {

	public List<AbstractBookService> getBookById(String id, List<AbstractLiBService> libServices) {
		List<AbstractBookService> bookServices = new ArrayList();
		for (AbstractLiBService libService : libServices) {
			IBookDao bookDao = libService.getBookDao();
			bookDao.getBookById(id, libService, bookServices);
		}

		return bookServices;

	}

	public List<AbstractBook> findCommand(String author, String nameBook, List<AbstractLiBService> libServices) {
		List<AbstractBook> foundBooks = new ArrayList();
		for (AbstractLiBService libService : libServices) {
			IBookDao bookDao = libService.getBookDao();
			bookDao.findCommand(author, nameBook, libService, foundBooks);
		}
		
		return foundBooks;

	}

	public void update(List<AbstractBookService> bookServices) throws IOException {
		for (AbstractBookService service : bookServices) {
			IBookDao bookDao = service.getBookDao();
			for (AbstractBook book : service.getBooks()) {
				bookDao.update(book);
			}
		}
	}

}
