package dao.api;

import java.io.IOException;
import java.util.List;

import dao.entity.AbstractBook;
import dao.entity.AbstractLib;

public interface IGeterBooks{
	
	List<AbstractBook> getBooks(AbstractLib lib) throws IOException;
	
	
}
