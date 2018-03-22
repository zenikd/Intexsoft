package control;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;
import update.IUpdater;

public class Return implements IExecutor {
	List<Book> books;
	String id;

	public Return(List<Book> books) {
		this.books = books;
	}

	public void execute(String command) {
		setParams(command);
		
		Book foundBook;
		
		try {
			foundBook = FinderBook.getByIndex(books, id);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return;
		}

		if (foundBook.getIssued().equals("")) {
			System.out.println("Already returned");
			return;
		}

		String issuedto = foundBook.getIssuedto();

		foundBook.setIssued("");
		foundBook.setIssuedto("");

		try {
			foundBook.update();
			System.out.println(String.format("OK abonent=<%s>", issuedto));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setParams(String command) {
		Scanner in = new Scanner(System.in);

		Pattern p1 = Pattern.compile("RETURN id=<[^>]+>");
		Matcher m1 = p1.matcher(command);

		m1.find();
		id = command.substring(11, m1.end() - 1);
		System.out.println(id);

	}

}
