package service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Book;
import dao.entity.AbstactLib;

public class GeterBooksByParams {
	public List<Book> find(List<AbstarctLiBService> libServices, ChekerBooksParams cheker) {
		List<Book> foundBook = new ArrayList();
		for (AbstarctLiBService libService : libServices) {
			List<AbstactLib> libs = libService.getLibs();
			
			for (AbstactLib lib : libs) {
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
