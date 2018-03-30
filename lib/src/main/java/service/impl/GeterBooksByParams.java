package service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Book;
import dao.entity.Lib;

public class GeterBooksByParams {
	public List<Book> find( List<Lib> libs, ChekerBooksParams cheker) {
		List<Book> foundBook = new ArrayList();

		for (Lib lib : libs) {
			List<Book> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = lib.getBooks();
				cheker.check(foundBook, notCheckedBooks);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return foundBook;
	}

}
