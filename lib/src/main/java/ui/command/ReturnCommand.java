package ui.command;

import service.BookService;
import service.result.ReturnResult;
import service.search.ReturnSearchParam;
import ui.api.ICommandExecutor;
import ui.parcer.ReturnCommandParser;

public class ReturnCommand implements ICommandExecutor {
	private final static BookService bookService = new BookService();
	
	public void execute(String command) {		
		ReturnCommandParser returnCommandParser = new ReturnCommandParser();

		ReturnSearchParam returnSearchParam = returnCommandParser.parseParams(command);

		ReturnResult returnResult = bookService.return_book(returnSearchParam);
		ReturnDemonstrator.showResult(returnResult);
	}

}
