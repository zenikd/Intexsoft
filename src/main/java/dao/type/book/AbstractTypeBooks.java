package dao.type.book;

import java.util.ArrayList;
import java.util.List;

import dao.api.IBook;
import dao.api.IBookType;
import dao.api.IFactory;

public abstract class AbstractTypeBooks implements IBookType{	
	private List<IBook> books = new ArrayList();	
	
	public AbstractTypeBooks(List<IBook> books) {
		super();
		this.books = books;
	}
	
	public void addBook(IBook book) {
		books.add(book);
	}	

	public List<IBook> getBooks(){
		return books;
	}
	
	public void removeBook(IBook book) {
		books.remove(book);
	}
	
	public abstract IFactory getFactory();
}
