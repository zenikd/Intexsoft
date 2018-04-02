package service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Book;
import dao.entity.Lib;

public class GeterBooksByParams {
	public List<Book> find(List<AbstarctLiBService> libServices, ChekerBooksParams cheker) {
		List<Book> foundBook = new ArrayList();
		for (AbstarctLiBService libService : libServices) {
			List<Lib> libs = libService.getLibs();
			
			for (Lib lib : libs) {
				List<Book> notCheckedBooks = new ArrayList();

				try {
					notCheckedBooks = libService.getGeterBooks().getBooks(lib);
					cheker.check(foundBook, notCheckedBooks);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return foundBook;
	}

}
