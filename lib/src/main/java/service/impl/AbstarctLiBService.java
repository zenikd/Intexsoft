package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.api.IGeterBooks;
import dao.entity.Lib;

public abstract class AbstarctLiBService {
	List<Lib> libs = new ArrayList();	
	
	public void addLib(Lib lib) {
		libs.add(lib);		
	}

	public void removeLib(Lib lib) {
		libs.remove(lib);
		
	}

	public List<Lib> getLibs() {
		return libs;
	}

	public abstract void setGeterBooks(IGeterBooks geter);

	public abstract IGeterBooks getGeterBooks();
}
