package dao.type.book;

import dao.api.IFactory;
import dao.factory.TxtFactory;

public class TxtTypeBooks extends AbstractTypeBooks {
	private final static IFactory factory = new TxtFactory();

	@Override
	public IFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}
}
