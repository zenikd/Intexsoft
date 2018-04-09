package ui.impl;

import java.io.IOException;
import java.util.List;

import service.impl.AbstractLiBService;
import service.impl.Return;
import service.results.ReturnResult;
import ui.api.ICommandExecutor;

public class ReturnCommand implements ICommandExecutor{

	public void execute(List<AbstractLiBService> libServices, String command) {		
		ReturnResult returnResult;
		try {
			returnResult = Return.execute(libServices, command);
			ResultReturnUI.showResult(returnResult);
		} catch (IOException e) {			
			e.printStackTrace();
			return;
		}
		
	}

}
