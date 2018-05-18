package ui.command;

import service.BookService;
import service.api.IResult;
import service.search.ReturnSearchParam;
import ui.api.ICommandExecutor;
import ui.parcer.ReturnCommandParser;

public class ReturnCommandExecutor implements ICommandExecutor {
	private final static BookService bookService = new BookService();
	
	public IResult execute(String command) {		
		ReturnCommandParser returnCommandParser = new ReturnCommandParser();

		ReturnSearchParam returnSearchParam = returnCommandParser.parseParams(command);

		return bookService.return_book(returnSearchParam);
	
	}

}
