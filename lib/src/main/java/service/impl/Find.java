package service.impl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.entity.AbstractBook;
import dao.impl.BookDaoImpl;

public class Find {
	private String author;
	private String nameBook;

	public List<AbstractBook> execute(List<AbstarctLiBService> libServices, String command) {
		setParams(command);

		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<AbstractBook> foundBooks = bookDaoImpl.findCommand(author, nameBook, libServices);

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
