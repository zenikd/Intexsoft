package service.impl;

import java.util.List;

import dao.entity.Book;

public abstract class ChekerBooksParams {
	public  abstract void check(List<Book> foundBook, List<Book> notChekedBooks);
}
