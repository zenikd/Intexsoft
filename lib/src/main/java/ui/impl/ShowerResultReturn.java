package ui.impl;

import service.results.ReturnResult;

public class ShowerResultReturn {
	public static void showResult(ReturnResult returnResult) {

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
