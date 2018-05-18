package ui.demonstrator;

import java.util.List;

import dao.api.IBook;
import service.api.IResult;
import service.result.FindCommandResult;

public class FindDemonstrator extends BaseDemonstrator{
	public  void showResult(IResult result) {
		FindCommandResult findCommandResult = (FindCommandResult) result;
		
		if(findCommandResult.isErrorCommand()) {
			showErrorCommand();
			return;
		}
		
		List<IBook> foundBooks =  findCommandResult.getBooks();
		
		if (foundBooks.size() == 0) {
			showNotFound();
			return;
		}

		for (IBook book : foundBooks) {

			if (!book.getIssued().equals("")) {
				System.out.println(String.format("FOUNDMISSING id=%s lib=%s issued=%s", book.getIndex(),
						book.getLib().getName(), book.getIssued()));
			} else {
				System.out.println(String.format("FOUND id=%s lib=%s", book.getIndex(), book.getLib().getName()));
			}
		}

	}
}
