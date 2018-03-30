package dao.api;

import java.io.IOException;
import java.util.List;

import dao.entity.Book;
import dao.entity.Lib;

public interface IGeterBooks{
	
	List<Book> getBooks(Lib lib) throws IOException;
	
	
}
