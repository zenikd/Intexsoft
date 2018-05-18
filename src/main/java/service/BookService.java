package service;

import java.util.List;

import dao.LibWrapper;
import dao.api.ILibType;
import service.result.FindCommandResult;
import service.result.OrderResult;
import service.result.ReturnResult;
import service.search.FindSearchParam;
import service.search.OrderSearchParam;
import service.search.ReturnSearchParam;

public class BookService {
	private final static LibWrapper commonLibDao = new LibWrapper();

	public ReturnResult return_book(ReturnSearchParam returnSearchParam) {

		List<ILibType> libCollections = commonLibDao.getLibs();

		return ReturnBookServiceHelper.execute(returnSearchParam, libCollections);
	}

	public OrderResult order_book(OrderSearchParam orderSearchParam) {
		List<ILibType> libCollections = commonLibDao.getLibs();

		return OrderBookServiceHelper.execute(libCollections, orderSearchParam);
	}

	public FindCommandResult findBook(FindSearchParam findSearchParam) {
		
		String author = findSearchParam.getAuthor();
		String nameBook = findSearchParam.getNameBook();

		FindCommandResult findResult = new FindCommandResult();

		if (author.isEmpty() && nameBook.isEmpty()) {
			findResult.setErrorCommand(true);
			return findResult;
		}

		List<ILibType> libCollections = commonLibDao.getLibs();

		return FindCommandBookServiceHelper.execute(libCollections, findSearchParam);
	}

}
