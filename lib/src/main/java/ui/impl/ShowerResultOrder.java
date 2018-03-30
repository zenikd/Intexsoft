package ui.impl;

import java.io.IOException;
import java.util.List;

import dao.entity.Lib;
import service.impl.Order;
import service.results.OrderResult;
import ui.api.IShower;

public class ShowerResultOrder implements IShower {

	public void show(List<Lib> libs, String command) {
		Order order = new Order();
		OrderResult orderResult;
		try {
			orderResult = order.execute(libs, command);
			showResult(orderResult);
		} catch (IOException e) {			
			e.printStackTrace();
			return;
		}
		
	}

	private void showResult(OrderResult orderResult) {	
		
		if (!orderResult.isFound()) {
			System.out.println("NOTFOUND");
			return;
		}
		
		if (orderResult.isBookRented()) {
			System.out.println(String.format("RESERVED abonent=<%s> date= <%s>", orderResult.getIssuedto(),
					orderResult.getIssued()));
			return;
		}
		
		System.out.println(String.format("OK abonent=<%s> date= <%s>", orderResult.getIssuedto(),
				orderResult.getIssued()));
	
	}

}
