package service;

import java.util.List;

import dao.BookWrapper;
import dao.api.IBook;
import dao.api.ILibType;
import service.result.FindCommandResult;
import service.search.FindSearchParam;

public class FindCommandBookServiceHelper {
	private final static BookWrapper bookWraper = new BookWrapper();

	public static FindCommandResult execute(List<ILibType> libCollections, FindSearchParam findSearchParam) {
		String author = findSearchParam.getAuthor();
		String nameBook = findSearchParam.getNameBook();

		FindCommandResult findResult = new FindCommandResult();

		List<IBook> foundBooks;
		foundBooks = bookWraper.findCommand(author, nameBook, libCollections);
		findResult.setBooks(foundBooks);

		return findResult;
	}

}
