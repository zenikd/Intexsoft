package service;

import java.util.List;

import dao.CommonLibDao;
import dao.api.ILibType;
import service.result.FindCommandResult;
import service.result.OrderResult;
import service.result.ReturnResult;
import service.search.FindSearchParam;
import service.search.OrderSearchParam;
import service.search.ReturnSearchParam;

public class BookService {	
	private final static CommonLibDao commonLibDao = new CommonLibDao();

	public ReturnResult return_book(ReturnSearchParam returnSearchParam) {

		List<ILibType> libCollections = commonLibDao.getLibs();

		return ReturnBookServiceHelper.execute(returnSearchParam, libCollections);
	}

	public OrderResult order_book(OrderSearchParam orderSearchParam) {
		List<ILibType> libCollections = commonLibDao.getLibs();

		return OrderBookServiceHelper.execute(libCollections, orderSearchParam);
	}

	public FindCommandResult find_book(FindSearchParam findSearchParam) {

		List<ILibType> libCollections = commonLibDao.getLibs();

		return FindCommandBookServiceHelper.execute(libCollections, findSearchParam);
	}

}
