package ui.impl;

import service.results.OrderResult;

public class ShowerResultOrder {
	public static void showResult(OrderResult orderResult) {

		if (!orderResult.isFound()) {
			System.out.println("NOTFOUND");
			return;
		}

		if (orderResult.isBookRented()) {
			System.out.println(String.format("RESERVED abonent=<%s> date= <%s>", orderResult.getIssuedto(),
					orderResult.getIssued()));
			return;
		}

		System.out.println(
				String.format("OK abonent=<%s> date= <%s>", orderResult.getIssuedto(), orderResult.getIssued()));

	}

}
