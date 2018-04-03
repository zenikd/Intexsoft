package dao.api;

import java.io.IOException;
import java.util.List;

import dao.entity.Book;
import dao.entity.AbstactLib;

public interface IGeterBooks{
	
	List<Book> getBooks(AbstactLib lib) throws IOException;
	
	
}
