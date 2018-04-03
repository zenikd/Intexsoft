package ui.impl;

import java.io.IOException;
import java.util.List;

import service.impl.AbstarctLiBService;
import service.impl.Return;
import service.results.ReturnResult;
import ui.api.ICommandExecutor;

public class ReturnCommand implements ICommandExecutor{

	public void execute(List<AbstarctLiBService> libServices, String command) {
		Return ret = new Return();
		ReturnResult returnResult;
		try {
			returnResult = ret.execute(libServices, command);
			ShowerResultReturn.showResult(returnResult);
		} catch (IOException e) {			
			e.printStackTrace();
			return;
		}
		
	}

}
