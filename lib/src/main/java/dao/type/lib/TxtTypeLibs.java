package dao.type.lib;

import dao.api.IFactory;
import dao.factory.TxtFactory;

public class TxtTypeLibs extends AbstractTypeLibs{
private final static IFactory factory = new TxtFactory();
	
	@Override
	public IFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}

}
