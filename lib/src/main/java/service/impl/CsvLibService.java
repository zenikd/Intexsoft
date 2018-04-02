package service.impl;

import dao.api.IGeterBooks;
import dao.impl.CsvGeterBooks;

public class CsvLibService extends AbstarctLiBService {
	IGeterBooks geterBooks = new CsvGeterBooks();

	@Override
	public void setGeterBooks(IGeterBooks geter) {
		geterBooks = geter;
	}

	@Override
	public IGeterBooks getGeterBooks() {
		return geterBooks;
	}

}
