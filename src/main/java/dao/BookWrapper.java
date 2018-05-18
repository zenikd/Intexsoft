package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.api.IBookDao;
import dao.api.IBook;
import dao.api.IBookType;
import dao.api.IFactory;
import dao.api.ILib;
import dao.api.ILibType;

public class BookWrapper {

	public List<IBookType> getBookById(String id, List<ILibType> libCollections) {
		List<IBookType> bookCollection = new ArrayList();
		for (ILibType libType : libCollections) {
			IFactory factory = libType.getFactory();
			IBookDao bookDao = factory.getBookDao();
			List<ILib> libs = libType.getLibs();
			bookCollection.add(bookDao.getById(id, libs));

		}

		return bookCollection;
	}

	public List<IBook> findCommand(String author, String nameBook, List<ILibType> libCollections) {
		List<IBook> foundBooks = new ArrayList();
		for (ILibType libType : libCollections) {
			IBookDao bookDao = libType.getFactory().getBookDao();
			List<ILib> libs = libType.getLibs();
			foundBooks.addAll(bookDao.findCommand(author, nameBook, libs));
		}

		return foundBooks;

	}

	public void update(List<IBookType> bookCollections) throws IOException {
		for (IBookType bookType : bookCollections) {
			IFactory factory = bookType.getFactory();
			IBookDao appSpecificallyBook = factory.getBookDao();
			List<IBook> books = bookType.getBooks();
			appSpecificallyBook.update(books);

		}
	}

}
