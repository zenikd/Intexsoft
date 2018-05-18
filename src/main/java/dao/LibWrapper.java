package dao;

import java.util.ArrayList;
import java.util.List;

import dao.api.ILib;
import dao.api.ILibType;
import dao.entity.Lib;
import dao.type.lib.CsvTypeLibs;
import dao.type.lib.TxtTypeLibs;

public class LibWrapper {
	public List<ILibType> getLibs() {
		List<ILibType> libCollections = new ArrayList<ILibType>();

		CsvTypeLibs csvTypeLibs = new CsvTypeLibs();
		ILib csvLib1 = new Lib("GRGU","D:\\lib\\grgu");	
		csvTypeLibs.addLib(csvLib1);

		TxtTypeLibs txtTypeLibs = new TxtTypeLibs();	
		ILib txtLib1 = new Lib("Good lib", "D:\\lib\\good_lib");

		txtTypeLibs.addLib(txtLib1);
		
		libCollections.add(txtTypeLibs);		
		libCollections.add(csvTypeLibs);
		
		return libCollections;
	}

}
