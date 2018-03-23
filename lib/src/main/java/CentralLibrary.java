import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import control.Find;
import control.IExecutor;
import control.UserPan;
import entity.Book;
import entity.Lib;
import opener.CsvOpener;
import opener.TextOpener;

public class CentralLibrary {
	List<Lib> libraries = new ArrayList();
	List<Book> books = new ArrayList();

	public CentralLibrary() {

		Lib lib = new Lib();
		lib.setOpener(new CsvOpener(lib));
		List<String> directories = new ArrayList();
		directories.add("D:\\Central_Library\\lib1\\text.csv");
		lib.setDirectories(directories);
		lib.setName("Lib 1");
		libraries.add(lib);

		Lib lib2 = new Lib();
		lib2.setOpener(new TextOpener(lib2));
		List<String> directories2 = new ArrayList();
		directories2.add("D:\\Central_Library\\lib2\\book1.properties");
		directories2.add("D:\\Central_Library\\lib2\\book2.properties");
		lib2.setDirectories(directories2);
		lib2.setName("Lib 2");
		libraries.add(lib2);

	}

	public void connect() {

		books = setAllBook(books);
		UserPan userPan = new UserPan(books);
		userPan.start();

	}

	public List<Book> setAllBook(List<Book> books) {

		for (Lib lib : libraries) {
			try {
				lib.open(books);
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return books;
	}
}
