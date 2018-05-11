package dao.api;

import java.util.List;

import dao.entity.AbstractLib;

public interface ILibType {
	void addLib(AbstractLib lib);
	
	 List<AbstractLib> getLibs();
	 
	 void removeLib(AbstractLib lib);
	 
	 IFactory getFactory();
}
