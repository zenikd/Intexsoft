package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.CommonBookDao;
import dao.api.IBookType;
import dao.api.ILibType;
import dao.entity.AbstractBook;
import service.result.OrderResult;
import service.search.OrderSearchParam;

public class OrderBookServiceHelper {
	private final static CommonBookDao commonBookDao = new CommonBookDao();
	private static String id;
	private static String issuedto;
	private static List<AbstractBook> books;

	/**
	 * 
	 * @param libCollections
	 *            the list lib service
	 * @param command
	 *            the text of the user command
	 * @return this return result
	 * @throws IOException
	 *             some update errors
	 */

	public static OrderResult execute(List<ILibType> libCollections, OrderSearchParam orderSearchParam) {
		String id = orderSearchParam.getId();
		String issuedto = orderSearchParam.getIssuedto();
		
		OrderResult orderResult = new OrderResult();
		
		if(id == null &&issuedto == null) {
			orderResult.setErrorCommand(true);
			return orderResult;
		}

		List<IBookType> bookCollections = commonBookDao.getBookById(id, libCollections);

		List<AbstractBook> foundBooks = new ArrayList();

		for (IBookType bookCollection : bookCollections) {
			for (AbstractBook book : bookCollection.getBooks()) {
				foundBooks.add(book);
			}
		}

		
		if (foundBooks.size() == 0) {
			orderResult.setFounded(false);
			return orderResult;
		}
		
		orderResult.setFounded(true);
		
		if (foundBooks.size() > 1) {
			orderResult.setMoreThanOne(true);
			return orderResult;
		}
		
		orderResult.setMoreThanOne(false);		
		
		AbstractBook foundBook =  foundBooks.get(0);

	
		if (foundBook.getIssued() == null || foundBook.getIssued().equals("")) {
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

		try {
			commonBookDao.update(bookCollections);
		} catch (IOException e) {
			orderResult.setProblemWithUpdate(true);
			e.printStackTrace();
		}
		orderResult.setProblemWithUpdate(false);
		
		return orderResult;

	}

}
