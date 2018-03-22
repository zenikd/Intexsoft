package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;

public class Find implements IExecutor {
	private String author;
	private String nameBook;
	List<Book> books;

	public Find(List<Book> books) {
		this.books = books;
	}

	public void execute(String command) {
		setParams(command);

		Pattern searchAuthor = Pattern.compile(author + "+");
		Pattern serachNameBook = Pattern.compile(nameBook + "+");

		List<Book> findBook = new ArrayList();

		for (Book book : books) {
			Matcher m1 = searchAuthor.matcher(book.getAuthor());
			Matcher m2 = serachNameBook.matcher(book.getNameBook());

			if (m1.lookingAt() && m2.lookingAt()) {
				findBook.add(book);
			}
		}

		showResult(findBook);
	}

	private void setParams(String command) {
		Scanner in = new Scanner(System.in);

		Pattern p1 = Pattern.compile("FIND \\[author=<[^>]+>\\]");
		Matcher m1 = p1.matcher(command);

		m1.find();
		author = command.substring(14, m1.end() - 2);

		Pattern p2 = Pattern.compile("\\[name=<[^>]+>\\]");
		Matcher m2 = p2.matcher(command);

		m2.find();

		nameBook = command.substring(m1.end()+8, m2.end() - 2);

	}

	private void showResult(List<Book> findBook) {
		if (findBook.size() == 0) {
			System.out.println("NOTFOUND");
			return;
		}

		for (Book book : findBook) {
			
			if (!book.getIssued().equals("")) {
				System.out.println(String.format("FOUNDMISSING id=%s lib=%s issued=%s", book.getIndex(),
						book.getLibName(), book.getIssued()));
			} else {
				System.out.println(String.format("FOUND id=%s lib=%s", book.getIndex(), book.getLibName()));
			}
		}

	}

}
