package ui.command;

import service.BookService;
import service.api.IResult;
import service.search.FindSearchParam;
import ui.api.ICommandExecutor;
import ui.parcer.FindCommandParser;

public class FindCommandExecutor implements ICommandExecutor {
	private final static BookService bookService = new BookService();
	private final static FindCommandParser findCommandParser = new FindCommandParser();

	public IResult execute(String command) {
		FindSearchParam findSearchParam = findCommandParser.parseParams(command);

		return bookService.findBook(findSearchParam);
		
	}

}
