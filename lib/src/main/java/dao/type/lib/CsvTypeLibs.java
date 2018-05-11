package dao.type.lib;

import dao.api.IFactory;
import dao.factory.CsvFactory;

public class CsvTypeLibs extends AbstractTypeLibs {
	private final static IFactory factory = new CsvFactory();

	@Override
	public IFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}

}
