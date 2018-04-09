package service.impl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.entity.AbstractBook;
import dao.impl.BookDaoImpl;

public class Find {
	private static String author;
	private static String nameBook;

	/**
	 * 
	 * @param libServices
	 *            the list lib service
	 * @param command
	 *            the text of the user command
	 * @return this return result
	 */

	public static List<AbstractBook> execute(List<AbstractLiBService> libServices, String command) {
		setParams(command);

		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<AbstractBook> foundBooks = bookDaoImpl.findCommand(author, nameBook, libServices);

		return foundBooks;
	}

	/**
	 * parse user command to author and nameBook
	 * 
	 * @param command
	 *            the text of the user command
	 */

	private static void setParams(String command) {
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
