package dao.impl.txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.entity.AbstractBook;
import dao.entity.AbstractLib;
import dao.entity.txt.TxtBook;
import dao.entity.txt.TxtLib;

public class TxtGeterBooks {

	public static List<AbstractBook> getBooks(AbstractLib lib) throws IOException {
		String libDirectory = ((TxtLib) lib).getDirectory();
		FileInputStream fileInputStream;

		File file = new File(libDirectory);
		File[] files = file.listFiles();
		List<AbstractBook> books = new ArrayList();

		for (File dir : files) {
			String bookDirectory = dir.toString();

			Properties prop = new Properties();

			fileInputStream = new FileInputStream(bookDirectory);
			prop.load(fileInputStream);

			TxtBook book = new TxtBook();

			book.setIndex(prop.getProperty("Index"));
			book.setAuthor(prop.getProperty("Author"));
			book.setNameBook(prop.getProperty("Name"));
			book.setIssued(prop.getProperty("Issued"));
			book.setIssuedto(prop.getProperty("Issuedto"));
			book.setAbstractLib(lib);
			book.setDirectory(bookDirectory);

			books.add(book);

		}

		return books;

	}
}