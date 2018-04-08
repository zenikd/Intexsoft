package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.api.IBookDao;
import dao.entity.AbstractLib;

public abstract class AbstractLiBService {
	List<AbstractLib> libs = new ArrayList();

	public void addLib(AbstractLib lib) {
		libs.add(lib);
	}

	public void removeLib(AbstractLib lib) {
		libs.remove(lib);

	}

	public List<AbstractLib> getLibs() {
		return libs;
	}

	public abstract IBookDao getBookDao();

	public abstract void setBookDao(IBookDao bookDao);
}
