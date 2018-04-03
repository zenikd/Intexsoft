package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.api.IGeterBooks;
import dao.entity.AbstactLib;

public abstract class AbstarctLiBService {
	List<AbstactLib> libs = new ArrayList();	
	
	public void addLib(AbstactLib lib) {
		libs.add(lib);		
	}

	public void removeLib(AbstactLib lib) {
		libs.remove(lib);
		
	}

	public List<AbstactLib> getLibs() {
		return libs;
	}

	public abstract void setGeterBooks(IGeterBooks geter);

	public abstract IGeterBooks getGeterBooks();
}
