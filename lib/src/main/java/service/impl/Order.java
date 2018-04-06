package service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import dao.impl.BookDaoImpl;
import service.results.OrderResult;

public class Order {
	private String id;
	private String issuedto;
	private List<AbstractBook> books;

	public OrderResult execute(List<AbstarctLiBService> libServices, String command) throws IOException {
		setParams(command);

		BookDaoImpl bookDao = new BookDaoImpl();

		List<AbstractBookService> bookServices = bookDao.getBookById(id, libServices);

		List<AbstractBook> foundBooks = new ArrayList();
		
		for(AbstractBookService service: bookServices) {
			foundBooks.add(service.getBooks().get(0));
		}
		
		AbstractBook foundBook;

		OrderResult orderResult = new OrderResult();
		try {

			foundBook = foundBooks.get(0);

		} catch (Exception e) {
			orderResult.setFound(false);
			return orderResult;
		}

		orderResult.setFound(true);
		if (foundBook.getIssued().equals("")) {
			orderResult.setBookRented(false);

			orderResult.setIssuedto(issuedto);
			Date date_d = new Date();
			SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy ");
			String data_s = formatForDateNow.format(date_d).toString();
			orderResult.setIssued(data_s);

			foundBook.setIssued(data_s);
			foundBook.setIssuedto(issuedto);
			
		} else {
			orderResult.setBookRented(true);

			orderResult.setIssued(foundBook.getIssued());
			orderResult.setIssuedto(foundBook.getIssuedto());

			return orderResult;
		}

		// foundBook.update();

		return orderResult;

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
	
	private void bookUpdate(List<AbstractBookService> bookServices) {
		for(AbstractBookService service: bookServices) {
			IBookDao bookDao = service.getBookDao();			
			for(AbstractBook book: service.getBooks()) {
				bookDao.up
			}
		}
		
	}

}