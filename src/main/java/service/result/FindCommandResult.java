package service.result;

import java.util.List;

import dao.api.IBook;

public class FindCommandResult extends BaseResult{
	private List<IBook> books;

	public List<IBook> getBooks() {
		return books;
	}

	public void setBooks(List<IBook> books) {
		this.books = books;
	}
	
	
}
