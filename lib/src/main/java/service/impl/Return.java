package service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.entity.AbstractBook;
import dao.impl.BookDaoImpl;
import service.results.ReturnResult;

public class Return {

	public ReturnResult execute(List<AbstarctLiBService> libServices, String command) throws IOException {
		String id = getId(command);

		BookDaoImpl bookDao = new BookDaoImpl();

		List<AbstractBookService> bookServices = bookDao.getBookById(id, libServices);

		List<AbstractBook> foundBooks = new ArrayList();
		
		for(AbstractBookService service: bookServices) {
			foundBooks.add(service.getBooks().get(0));
		}
		
		AbstractBook foundBook;

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

	private String getId(String command) {
		Scanner in = new Scanner(System.in);

		Pattern p1 = Pattern.compile("RETURN id=<[^>]+>");
		Matcher m1 = p1.matcher(command);

		m1.find();
		return command.substring(11, m1.end() - 1);

	}

}
