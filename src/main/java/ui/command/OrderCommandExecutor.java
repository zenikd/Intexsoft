package ui.command;

import service.BookService;
import service.api.IResult;
import service.search.OrderSearchParam;
import ui.api.ICommandExecutor;
import ui.parcer.OrderCommandParser;

public class OrderCommandExecutor implements ICommandExecutor {
	private final static BookService bookService = new BookService();

	public IResult execute(String command) {

		OrderCommandParser orderCommandParser = new OrderCommandParser();

		OrderSearchParam orderSearchParam = orderCommandParser.parseParams(command);

		return bookService.order_book(orderSearchParam);

	}

}
