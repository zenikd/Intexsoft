package dao.type.book;

import dao.api.IFactory;
import dao.factory.CsvFactory;

public class CsvTypeBooks extends AbstractTypeBooks {
	private final static IFactory factory = new CsvFactory();

	@Override
	public IFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}

}
