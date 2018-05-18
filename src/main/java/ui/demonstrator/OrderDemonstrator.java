package ui.demonstrator;

import service.api.IResult;
import service.result.OrderResult;

public class OrderDemonstrator extends BaseDemonstrator{
	public  void showResult(IResult result) {
		OrderResult orderResult = (OrderResult) result;
		if(orderResult.isErrorCommand()) {
			showErrorCommand();
			return;
		}

		if (!orderResult.isFounded()) {
			showNotFound();
			return;
		}
		
		if (orderResult.isMoreThanOne()) {
			System.out.println("Error! Books with this id more than one");
			return;
		}
		

		if (orderResult.isBookRented()) {
			System.out.println(String.format("RESERVED abonent=<%s> date= <%s>", orderResult.getIssuedto(),
					orderResult.getIssued()));
			return;
		}
		
		if (orderResult.isProblemWithUpdate()) {
			System.out.println("Sorry, problems with the order. Please try again");
			return;
		}

		System.out.println(
				String.format("OK abonent=<%s> date= <%s>", orderResult.getIssuedto(), orderResult.getIssued()));

	}
}
