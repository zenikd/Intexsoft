package ui.command;

import service.BookService;
import service.result.FindCommandResult;
import service.search.FindSearchParam;
import ui.api.ICommandExecutor;
import ui.parcer.FindCommandParser;

public class FindCommand implements ICommandExecutor {
	private final static BookService bookService = new BookService();

	public void execute(String command) {
		FindCommandParser findCommandParser = new FindCommandParser();

		FindSearchParam findSearchParam = findCommandParser.parseParams(command);

		FindCommandResult findCommandResult = bookService.find_book(findSearchParam);
		FindDemonstrator.showResult(findCommandResult);
	}

}
