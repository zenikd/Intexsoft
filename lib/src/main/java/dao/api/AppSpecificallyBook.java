package dao.api;

import java.io.IOException;
import java.util.List;

import dao.entity.AbstractBook;

public interface AppSpecificallyBook {
	
	IBookType getById(String id, ILibType libCollection);

	List<AbstractBook> findCommand(String author, String nameBook, ILibType libCollection);

	void update(IBookType bookCollection) throws IOException;

}
