package dao.type.lib;

import java.util.ArrayList;
import java.util.List;

import dao.api.IFactory;
import dao.api.ILib;
import dao.api.ILibType;

public abstract class AbstractTypeLibs implements ILibType {
private List<ILib> libs = new ArrayList();	
	
	public void addLib(ILib lib) {
		libs.add(lib);
	}
	
	public List<ILib> getLibs(){
		return libs;
	}
	
	public void removeLib(ILib lib) {
		libs.remove(lib);
	}
	
	public abstract IFactory getFactory();

}
