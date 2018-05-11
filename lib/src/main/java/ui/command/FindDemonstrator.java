package ui.command;

import java.util.List;

import dao.entity.AbstractBook;
import service.result.FindCommandResult;

public class FindDemonstrator extends BaseDemonstrate{
	public static void showResult(FindCommandResult findCommandResult) {
		if(findCommandResult.isErrorCommand()) {
			showErrorCommand();
			return;
		}
		
		List<AbstractBook> foundBooks =  findCommandResult.getBooks();
		
		if (foundBooks.size() == 0) {
			showNotFound();
			return;
		}

		for (AbstractBook book : foundBooks) {

			if (!book.getIssued().equals("")) {
				System.out.println(String.format("FOUNDMISSING id=%s lib=%s issued=%s", book.getIndex(),
						book.getAbstractLib().getName(), book.getIssued()));
			} else {
				System.out.println(String.format("FOUND id=%s lib=%s", book.getIndex(), book.getAbstractLib().getName()));
			}
		}

	}
}
