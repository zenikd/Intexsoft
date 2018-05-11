package dao.type.book;

import java.util.ArrayList;
import java.util.List;

import dao.api.IBookType;
import dao.api.IFactory;
import dao.entity.AbstractBook;

public abstract class AbstractTypeBooks implements IBookType{
	private List<AbstractBook> books = new ArrayList();	
	
	public void addBook(AbstractBook book) {
		books.add(book);
	}
	
	public List<AbstractBook> getBooks(){
		return books;
	}
	
	public void removeBook(AbstractBook book) {
		books.remove(book);
	}
	
	public abstract IFactory getFactory();
}
