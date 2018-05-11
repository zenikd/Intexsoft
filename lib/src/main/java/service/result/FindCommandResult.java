package service.result;

import java.util.List;

import dao.entity.AbstractBook;

public class FindCommandResult extends BaseResult{
	private List<AbstractBook> books;

	public List<AbstractBook> getBooks() {
		return books;
	}

	public void setBooks(List<AbstractBook> books) {
		this.books = books;
	}
	
	
}
