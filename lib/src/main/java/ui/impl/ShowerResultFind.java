package ui.impl;

import java.util.List;

import dao.entity.AbstractBook;

public class ShowerResultFind {


	public static void showResult(List<AbstractBook> foundBooks) {
		if (foundBooks.size() == 0) {
			System.out.println("NOTFOUND");
			return;
		}

		for (AbstractBook book : foundBooks) {

			if (!book.getIssued().equals("")) {
				System.out.println(String.format("FOUNDMISSING id=%s lib=%s issued=%s", book.getIndex(),
						book.getLib().getName(), book.getIssued()));
			} else {
				System.out.println(String.format("FOUND id=%s lib=%s", book.getIndex(), book.getLib().getName()));
			}
		}

	}

}
