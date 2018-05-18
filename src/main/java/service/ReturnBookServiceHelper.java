package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.BookWrapper;
import dao.api.IBook;
import dao.api.IBookType;
import dao.api.ILibType;
import service.result.ReturnResult;
import service.search.ReturnSearchParam;

public class ReturnBookServiceHelper {
	private final static BookWrapper bookWraper = new BookWrapper();

	public static ReturnResult execute(ReturnSearchParam returnSearchParam, List<ILibType> libCollections) {
		
		ReturnResult resultReturn = new ReturnResult();

		String id = returnSearchParam.getId();
		
		if(id == null) {
			resultReturn.setErrorCommand(true);
		}

		List<IBookType> bookCollections = bookWraper.getBookById(id, libCollections);

		List<IBook> foundBooks = new ArrayList();

		for (IBookType bookCollection : bookCollections) {
			for (IBook book : bookCollection.getBooks()) {
				foundBooks.add(book);
			}
		}
	
		if (foundBooks.size() == 0) {

			resultReturn.setFounded(false);
			return resultReturn;
		}

		resultReturn.setFounded(true);

		if (foundBooks.size() > 1) {

			resultReturn.setMoreThanOne(true);
			return resultReturn;

		}

		resultReturn.setMoreThanOne(false);

		IBook foundBook = foundBooks.get(0);

		if (foundBook.getIssued() == null || foundBook.getIssued().equals("")) {
			resultReturn.setReturnedEarly(true);
			return resultReturn;
		}

		resultReturn.setReturnedEarly(false);

		String issuedto = foundBook.getIssuedto();

		resultReturn.setIssuedto(issuedto);

		foundBook.setIssued("");
		foundBook.setIssuedto("");

		try {
			bookWraper.update(bookCollections);
		} catch (IOException e) {
			e.printStackTrace();
			resultReturn.setProblemWithUpdate(true);
			;
			return resultReturn;
		}

		resultReturn.setProblemWithUpdate(false);

		return resultReturn;

	}

	

}
