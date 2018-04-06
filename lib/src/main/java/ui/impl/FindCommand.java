package ui.impl;

import java.util.List;

import dao.entity.AbstractBook;
import service.impl.AbstarctLiBService;
import service.impl.Find;
import ui.api.ICommandExecutor;

public class FindCommand implements ICommandExecutor{

	public void execute(List<AbstarctLiBService> libServices, String command) {
		Find find = new Find();
		List<AbstractBook> foundBooks = find.execute(libServices, command);
		ShowerResultFind.showResult(foundBooks);
		
	}

}
