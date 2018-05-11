package ui.command;

import service.BookService;
import service.result.OrderResult;
import service.search.OrderSearchParam;
import ui.api.ICommandExecutor;
import ui.parcer.OrderCommandParser;

public class OrderCommand implements ICommandExecutor {
	private final static BookService bookService = new BookService();

	public void execute(String command) {

		OrderCommandParser orderCommandParser = new OrderCommandParser();

		OrderSearchParam orderSearchParam = orderCommandParser.parseParams(command);

		OrderResult orderResult = bookService.order_book(orderSearchParam);

		OrderDemonstrator.showResult(orderResult);

	}

}
