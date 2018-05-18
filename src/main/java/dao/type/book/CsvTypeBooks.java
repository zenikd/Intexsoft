package dao.type.book;

import java.util.List;

import dao.api.IBook;
import dao.api.IFactory;
import dao.factory.CsvFactory;

public class CsvTypeBooks extends AbstractTypeBooks {
	private final static IFactory factory = new CsvFactory();
	
	public CsvTypeBooks(List<IBook> books) {
		super(books);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}

	

}
