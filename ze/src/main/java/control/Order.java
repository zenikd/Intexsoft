package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;

public class Order implements IExecutor {
	private String id;
	private String issuedto;
	List<Book> books;

	public Order(List<Book> books) {
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

		if (!foundBook.getIssued().equals("")) {
			System.out.println(
					String.format("RESERVED abonent=<%s> date= <%s>", foundBook.getIssuedto(), foundBook.getIssued()));
			return;
		}

		foundBook.setIssuedto(issuedto);

		Date date_d = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy ");
		String data_s = formatForDateNow.format(date_d).toString();

		foundBook.setIssued(data_s);

		try {
			foundBook.update();
			System.out.println(
					String.format("OK abonent=<%s> date= <%s>", foundBook.getIssuedto(), foundBook.getIssued()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setParams(String command) {
		Scanner in = new Scanner(System.in);

		Pattern p1 = Pattern.compile("ORDER id=<[^>]+>");
		Matcher m1 = p1.matcher(command);

		m1.find();
		id = command.substring(10, m1.end() - 1);

		Pattern p2 = Pattern.compile("abonent=<[^>]+>");
		Matcher m2 = p2.matcher(command);

		m2.find();
		issuedto = command.substring(m1.end() + 10, m2.end() - 1);

	}

}