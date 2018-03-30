package service.impl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.entity.Book;
import dao.entity.Lib;

public class Find {
	private String author;
	private String nameBook;
	private List<Book> books;

	public List<Book> execute(List<Lib> libs, String command) {
		setParams(command);

		GeterBooksByParams geterBooksByParams = new GeterBooksByParams();

		List<Book> foundBooks = geterBooksByParams.find(libs, new ChekerBooksParams() {

			@Override
			public void check(List<Book> findBooks, List<Book> notChekedBooks) {

				Pattern searchAuthor = Pattern.compile(author);
				Pattern serachNameBook = Pattern.compile(nameBook);

				for (Book book : notChekedBooks) {
					Matcher m1 = searchAuthor.matcher(book.getAuthor());
					Matcher m2 = serachNameBook.matcher(book.getNameBook());

					if (m1.lookingAt() && m2.lookingAt()) {
						findBooks.add(book);
					}
				}
			}
		});

		return foundBooks;
	}

	private void setParams(String command) {
		Scanner in = new Scanner(System.in);

		Pattern p1 = Pattern.compile("FIND \\[author=<[^>]*>\\]");
		Matcher m1 = p1.matcher(command);

		m1.find();
		author = command.substring(14, m1.end() - 2);

		Pattern p2 = Pattern.compile("\\[name=<[^>]*>\\]");
		Matcher m2 = p2.matcher(command);

		m2.find();

		nameBook = command.substring(m1.end() + 8, m2.end() - 2);

	}

}
