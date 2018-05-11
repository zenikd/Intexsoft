package dao.api;

import java.util.List;

import dao.entity.AbstractBook;

public interface IBookType {
	void addBook(AbstractBook book);

	List<AbstractBook> getBooks();

	void removeBook(AbstractBook book);

	IFactory getFactory();

}
