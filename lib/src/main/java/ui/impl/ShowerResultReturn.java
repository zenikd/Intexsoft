package ui.impl;

import java.io.IOException;
import java.util.List;

import dao.entity.Lib;
import service.impl.Return;
import service.results.OrderResult;
import service.results.ReturnResult;
import ui.api.IShower;

public class ShowerResultReturn implements IShower {

	public void show(List<Lib> libs, String command) {
		Return ret = new Return();
		ReturnResult returnResult;
		try {
			returnResult = ret.execute(libs, command);
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
