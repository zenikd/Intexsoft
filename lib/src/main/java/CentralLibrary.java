import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Book;
import dao.entity.Lib;
import dao.impl.CsvGeterBooks;
import dao.impl.TextGeterBooks;
import ui.impl.UserPan;

public class CentralLibrary {
	List<Lib> libraries = new ArrayList();
	List<Book> books = new ArrayList();

	public CentralLibrary() {

		Lib lib = new Lib();
		lib.setGeterBooks(new CsvGeterBooks());
		List<String> directories = new ArrayList();
		directories.add("D:\\Central_Library\\lib1\\text.csv");
		lib.setDirectories(directories);
		lib.setName("Lib 1");
		libraries.add(lib);

		Lib lib2 = new Lib();
		lib2.setGeterBooks(new TextGeterBooks());
		List<String> directories2 = new ArrayList();
		directories2.add("D:\\Central_Library\\lib2\\book1.properties");
		directories2.add("D:\\Central_Library\\lib2\\book2.properties");
		lib2.setDirectories(directories2);
		lib2.setName("Lib 2");
		libraries.add(lib2);

	}

	public void connect() {

		UserPan userPan = new UserPan();
		userPan.start(libraries);

	}

}
