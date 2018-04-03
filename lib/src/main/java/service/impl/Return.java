package service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.entity.Book;
import dao.entity.AbstactLib;
import service.results.ReturnResult;

public class Return {
	private List<Book> books;
	private String id;

	public ReturnResult execute(List<AbstarctLiBService> libServices, String command) throws IOException {
		setParams(command);

		Book foundBook;

		GeterBooksByParams geterBooksByParams = new GeterBooksByParams();

		List<Book> foundBooks = geterBooksByParams.find(libServices, new ChekerBooksParams() {

			@Override
			public void check(List<Book> findBooks, List<Book> notChekedBooks) {

				for (Book book : notChekedBooks) {

					if (book.getIndex().equals(id)) {
						findBooks.add(book);

					}
				}
			}
		});

		ReturnResult returnResult = new ReturnResult();
		try {
			foundBook = foundBooks.get(0);
		} catch (Exception e) {
			returnResult.setFound(false);
			return returnResult;
		}

		returnResult.setFound(true);

		if (foundBook.getIssued().equals("")) {

			return returnResult;
		}

		String issuedto = foundBook.getIssuedto();

		returnResult.setIssuedto(issuedto);

		foundBook.setIssued("");
		foundBook.setIssuedto("");

		foundBook.update();

		return returnResult;

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
