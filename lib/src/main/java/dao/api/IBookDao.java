package dao.api;

import java.io.IOException;
import java.util.List;

import dao.entity.AbstractBook;
import service.impl.AbstarctLiBService;
import service.impl.AbstractBookService;

public interface IBookDao {
	public void getBookById(String id, AbstarctLiBService libService, List<AbstractBookService> bookServices) ;
	
	public void findCommand(String author, String nameBook , AbstarctLiBService libService, List<AbstractBook> foundBooks);
	
	public void update(AbstractBook book) throws IOException;
}
