package ui.impl;

import java.io.IOException;
import java.util.List;

import service.impl.AbstarctLiBService;
import service.impl.Order;
import service.results.OrderResult;
import ui.api.ICommandExecutor;

public class OrderCommand implements ICommandExecutor {

	public void execute(List<AbstarctLiBService> libServices, String command) {
		Order order = new Order();
		OrderResult orderResult;
		try {
			orderResult = order.execute(libServices, command);
			ShowerResultOrder.showResult(orderResult);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

}
