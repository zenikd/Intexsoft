package ui.impl;

import java.util.List;

import dao.entity.AbstractBook;
import service.impl.AbstractLiBService;
import service.impl.Find;
import ui.api.ICommandExecutor;

public class FindCommand implements ICommandExecutor{

	public void execute(List<AbstractLiBService> libServices, String command) {		
		List<AbstractBook> foundBooks = Find.execute(libServices, command);
		ResultFindUI.showResult(foundBooks);
		
	}

}
