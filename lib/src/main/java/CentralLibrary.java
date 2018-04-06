import java.util.ArrayList;
import java.util.List;

import dao.entity.AbstractLib;
import dao.entity.AbstractBook;
import dao.entity.CsvLib;
import dao.entity.TextLib;
import service.impl.AbstarctLiBService;
import service.impl.CsvLibService;
import service.impl.DbLibService;
import service.impl.TextLibService;
import ui.impl.UserPan;

public class CentralLibrary {
	List<AbstarctLiBService> libServices = new ArrayList();
	List<AbstractBook> books = new ArrayList();

	public CentralLibrary() {

		AbstarctLiBService csvLibService = new CsvLibService();

		AbstarctLiBService textLibService = new TextLibService();

		CsvLib lib = new CsvLib();		
		lib.setDirectory("D:\\Central_Library\\lib1\\text.csv");
		lib.setName("Lib 1");
		csvLibService.addLib(lib);
		libServices.add(csvLibService);

		TextLib lib2 = new TextLib();
		List<String> directories2 = new ArrayList();
		directories2.add("D:\\Central_Library\\lib2\\book1.properties");
		directories2.add("D:\\Central_Library\\lib2\\book2.properties");
		lib2.setDirectories(directories2);
		lib2.setName("Lib 2");
		textLibService.addLib(lib2);
		libServices.add(textLibService);
		
		DbLibService lib3 = new DbLibService();
		libServices.add(lib3);
	}

	public void connect() {

		UserPan userPan = new UserPan();
		userPan.start(libServices);

	}

}
