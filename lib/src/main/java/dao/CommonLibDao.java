package dao;

import java.util.ArrayList;
import java.util.List;

import dao.api.ILibType;
import dao.entity.csv.CsvLib;
import dao.entity.txt.TxtLib;
import dao.type.lib.CsvTypeLibs;
import dao.type.lib.TxtTypeLibs;

public class CommonLibDao {
	public List<ILibType> getLibs() {
		List<ILibType> libCollections = new ArrayList<ILibType>();

		CsvTypeLibs csvTypeLibs = new CsvTypeLibs();
		CsvLib csvLib1 = new CsvLib("GRGU","D:\\lib\\grgu");	
		csvTypeLibs.addLib(csvLib1);

		TxtTypeLibs txtTypeLibs = new TxtTypeLibs();	
		TxtLib txtLib1 = new TxtLib("Good lib", "D:\\lib\\good_lib");

		txtTypeLibs.addLib(txtLib1);
		
		libCollections.add(txtTypeLibs);		
		libCollections.add(csvTypeLibs);
		
		return libCollections;
	}

}
