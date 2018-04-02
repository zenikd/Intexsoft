package service.impl;

import dao.api.IGeterBooks;
import dao.impl.TextGeterBooks;

public class TextLibService extends AbstarctLiBService {
	IGeterBooks geterBooks = new TextGeterBooks();

	@Override
	public void setGeterBooks(IGeterBooks geter) {
		geterBooks = geter;
	}

	@Override
	public IGeterBooks getGeterBooks() {
		return geterBooks;
	}

}