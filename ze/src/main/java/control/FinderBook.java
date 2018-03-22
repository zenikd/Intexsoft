package control;

import java.util.List;

import entity.Book;

public class FinderBook {
	public static Book getByIndex(List<Book> books, String id) throws NullPointerException{
		
		for(Book book: books) {
			if(id.equals(book.getIndex())) {
				return book;
			}
		}
		
		throw new NullPointerException("Book with this id isn't found");
	}

}
