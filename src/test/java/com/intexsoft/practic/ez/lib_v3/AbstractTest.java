package com.intexsoft.practic.ez.lib_v3;

import java.util.Random;

import service.BookService;
import service.result.FindCommandResult;
import service.result.OrderResult;
import service.result.ReturnResult;
import service.search.FindSearchParam;
import service.search.OrderSearchParam;
import service.search.ReturnSearchParam;

public class AbstractTest {

	BookService bookService = new BookService();

	private final Random RANDOM = new Random();
	
	protected ReturnResult returnCommand(String id) {
		ReturnSearchParam returnSearchParam = new ReturnSearchParam();
		returnSearchParam.setId(id);
				
		return bookService.return_book(returnSearchParam);
	}
	
	protected OrderResult orderCommand(String id, String issuedto) {
		OrderSearchParam orderSearchParam = new OrderSearchParam();
		orderSearchParam.setId(id);
		orderSearchParam.setIssuedto(issuedto);
				
		return bookService.order_book(orderSearchParam);
	}

	protected FindCommandResult findCommand(String author, String nameBook) {
		FindSearchParam findSearchParam = new FindSearchParam();
		findSearchParam.setAuthor(author);
		findSearchParam.setNameBook(nameBook);
				
		return bookService.findBook(findSearchParam);
	}

	

	protected String getRandomPrefix() {
		return RANDOM.nextInt(999999999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(99999999) + 1;
	}

	protected boolean getRandomBool() {
		if (RANDOM.nextInt(2) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
