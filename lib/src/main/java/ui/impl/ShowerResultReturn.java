package ui.impl;

import java.io.IOException;
import java.util.List;

import service.impl.AbstarctLiBService;
import service.impl.Return;
import service.results.ReturnResult;
import ui.api.IShower;

public class ShowerResultReturn implements IShower {

	public void show(List<AbstarctLiBService> libServices, String command) {
		Return ret = new Return();
		ReturnResult returnResult;
		try {
			returnResult = ret.execute(libServices, command);
			showResult(returnResult);
		} catch (IOException e) {			
			e.printStackTrace();
			return;
		}
	
	}

	private void showResult(ReturnResult returnResult) {

		if (!returnResult.isFound()) {
			System.out.println("NOTFOUND");
			return;
		}

		if (returnResult.getIssuedto() == null) {
			System.out.println("ALREADY RETURNED");
			return;
		}

		System.out.println(String.format("OK abonent=<%s>", returnResult.getIssuedto()));

	}

}
