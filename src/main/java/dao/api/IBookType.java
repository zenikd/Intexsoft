package dao.api;

import java.util.List;

public interface IBookType {
	void addBook(IBook book);

	List<IBook> getBooks();

	void removeBook(IBook book);

	IFactory getFactory();

}
