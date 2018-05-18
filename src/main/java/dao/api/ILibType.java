package dao.api;

import java.util.List;

public interface ILibType {
	void addLib(ILib lib);
	
	 List<ILib> getLibs();
	 
	 void removeLib(ILib lib);
	 
	 IFactory getFactory();
}
