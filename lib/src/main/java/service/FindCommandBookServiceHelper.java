package service;

import java.util.List;

import dao.CommonBookDao;
import dao.api.ILibType;
import dao.entity.AbstractBook;
import service.result.FindCommandResult;
import service.search.FindSearchParam;

public class FindCommandBookServiceHelper {
	private final static CommonBookDao commonBookDao = new CommonBookDao();
	
	public static FindCommandResult execute(List<ILibType> libCollections, FindSearchParam findSearchParam) {
		String author = findSearchParam.getAuthor();
		String nameBook = findSearchParam.getNameBook();
		
		FindCommandResult findResult = new FindCommandResult();
		
		if(author.isEmpty() && nameBook.isEmpty()) {
			findResult.setErrorCommand(true);
			return findResult;
		}
		
		List<AbstractBook> foundBooks;
		foundBooks = commonBookDao.findCommand(author, nameBook, libCollections);
		findResult.setBooks(foundBooks);
		
		return findResult;
	}

	

}
