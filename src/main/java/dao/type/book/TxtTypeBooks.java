package dao.type.book;

import java.util.List;

import dao.api.IBook;
import dao.api.IFactory;
import dao.factory.TxtFactory;

public class TxtTypeBooks extends AbstractTypeBooks {
	private final static IFactory factory = new TxtFactory();
	
	public TxtTypeBooks(List<IBook> books) {
		super(books);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}
}
