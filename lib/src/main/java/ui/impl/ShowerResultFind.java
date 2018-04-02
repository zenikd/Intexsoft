package ui.impl;

import java.util.List;

import dao.entity.Book;
import dao.entity.Lib;
import service.impl.AbstarctLiBService;
import service.impl.Find;
import ui.api.IShower;

public class ShowerResultFind implements IShower {

	public void show(List<AbstarctLiBService> libServices, String command) {
		Find find = new Find();
		List<Book> foundBooks = find.execute(libServices, command);
		showResult(foundBooks);
	}

	private void showResult(List<Book> foundBooks) {
		if (foundBooks.size() == 0) {
			System.out.println("NOTFOUND");
			return;
		}

		for (Book book : foundBooks) {

			if (!book.getIssued().equals("")) {
				System.out.println(String.format("FOUNDMISSING id=%s lib=%s issued=%s", book.getIndex(),
						book.getLibName(), book.getIssued()));
			} else {
				System.out.println(String.format("FOUND id=%s lib=%s", book.getIndex(), book.getLibName()));
			}
		}

	}

}
