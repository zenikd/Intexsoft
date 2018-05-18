package ui.demonstrator;

import service.api.IResult;
import service.result.ReturnResult;

public class ReturnDemonstrator extends BaseDemonstrator{
	public  void showResult(IResult result) {
		ReturnResult returnResult = (ReturnResult) result;
		if(returnResult.isErrorCommand()) {
			showErrorCommand();
			return;
		}

		if (!returnResult.isFounded()) {
			showNotFound();
			return;
		}
		
		if (returnResult.isMoreThanOne()) {
			System.out.println("Error! Books with this id more than one");
			return;
		}

		if (returnResult.isReturnedEarly()) {
			System.out.println("ALREADY RETURNED");
			return;
		}
		
		if (returnResult.isProblemWithUpdate()) {
			System.out.println("Sorry, problems with the return. Please try again");
			return;
		}

		System.out.println(String.format("OK abonent=<%s>", returnResult.getIssuedto()));

	}

}
