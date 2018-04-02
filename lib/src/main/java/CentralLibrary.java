import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Book;
import dao.entity.Lib;
import dao.impl.CsvGeterBooks;
import dao.impl.TextGeterBooks;
import service.impl.AbstarctLiBService;
import service.impl.CsvLibService;
import service.impl.TextLibService;
import ui.impl.UserPan;

public class CentralLibrary {
	List<AbstarctLiBService> libServices = new ArrayList();
	List<Book> books = new ArrayList();

	public CentralLibrary() {

		AbstarctLiBService csvLibService = new CsvLibService();

		AbstarctLiBService textLibService = new TextLibService();

		Lib lib = new Lib();
		List<String> directories = new ArrayList();
		directories.add("D:\\Central_Library\\lib1\\text.csv");
		lib.setDirectories(directories);
		lib.setName("Lib 1");
		csvLibService.addLib(lib);
		libServices.add(csvLibService);

		Lib lib2 = new Lib();
		List<String> directories2 = new ArrayList();
		directories2.add("D:\\Central_Library\\lib2\\book1.properties");
		directories2.add("D:\\Central_Library\\lib2\\book2.properties");
		lib2.setDirectories(directories2);
		lib2.setName("Lib 2");
		textLibService.addLib(lib2);
		libServices.add(textLibService);
	}

	public void connect() {

		UserPan userPan = new UserPan();
		userPan.start(libServices);

	}

}
