package ui.impl;

import java.io.IOException;
import java.util.List;

import service.impl.AbstractLiBService;
import service.impl.Order;
import service.results.OrderResult;
import ui.api.ICommandExecutor;

public class OrderCommand implements ICommandExecutor {

	public void execute(List<AbstractLiBService> libServices, String command) {
		OrderResult orderResult;
		try {
			orderResult = Order.execute(libServices, command);
			ResultOrderUI.showResult(orderResult);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

}
