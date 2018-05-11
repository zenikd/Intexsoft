package dao.type.lib;

import java.util.ArrayList;
import java.util.List;

import dao.api.IFactory;
import dao.api.ILibType;
import dao.entity.AbstractLib;

public abstract class AbstractTypeLibs implements ILibType {
private List<AbstractLib> libs = new ArrayList();	
	
	public void addLib(AbstractLib lib) {
		libs.add(lib);
	}
	
	public List<AbstractLib> getLibs(){
		return libs;
	}
	
	public void removeLib(AbstractLib lib) {
		libs.remove(lib);
	}
	
	public abstract IFactory getFactory();

}
