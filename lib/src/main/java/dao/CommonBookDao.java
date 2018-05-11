package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.api.AppSpecificallyBook;
import dao.api.IBookType;
import dao.api.IFactory;
import dao.api.ILibType;
import dao.entity.AbstractBook;

public class CommonBookDao {

	public List<IBookType> getBookById(String id, List<ILibType> libCollections) {
		List<IBookType> bookCollection = new ArrayList();
		for (ILibType abstractLibCollection : libCollections) {
			IFactory factory = abstractLibCollection.getFactory();
			AppSpecificallyBook bookDao = factory.getBookDao();
			bookCollection.add(bookDao.getById(id, abstractLibCollection));

		}

		return bookCollection;
	}

	public List<AbstractBook> findCommand(String author, String nameBook, List<ILibType> libCollections) {
		List<AbstractBook> foundBooks = new ArrayList();
		for (ILibType libCollection : libCollections) {
			AppSpecificallyBook bookDao = libCollection.getFactory().getBookDao();
			foundBooks.addAll(bookDao.findCommand(author, nameBook, libCollection));
		}

		return foundBooks;

	}

	public void update(List<IBookType> bookCollections) throws IOException {
		for (IBookType abstractBookCollection : bookCollections) {
			IFactory factory = abstractBookCollection.getFactory();
			AppSpecificallyBook appSpecificallyBook = factory.getBookDao();

			appSpecificallyBook.update(abstractBookCollection);

		}
	}

}
