package ui.command;

import service.result.ReturnResult;

public class ReturnDemonstrator extends BaseDemonstrate{
	public static void showResult(ReturnResult returnResult) {
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
