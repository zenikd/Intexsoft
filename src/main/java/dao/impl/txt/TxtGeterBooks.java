package dao.impl.txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.api.IBook;
import dao.api.ILib;
import dao.entity.Book;

public class TxtGeterBooks {

	public static List<IBook> getBooks(ILib lib) throws IOException {
		String libDirectory = lib.getDirectory();
		FileInputStream fileInputStream;

		File file = new File(libDirectory);
		File[] files = file.listFiles();
		List<IBook> books = new ArrayList();

		for (File dir : files) {
			String bookDirectory = dir.toString();

			Properties prop = new Properties();

			fileInputStream = new FileInputStream(bookDirectory);
			prop.load(fileInputStream);

			IBook book = new Book(prop.getProperty("Index"), bookDirectory);

			book.setAuthor(prop.getProperty("Author"));
			book.setNameBook(prop.getProperty("Name"));
			book.setIssued(prop.getProperty("Issued"));
			book.setIssuedto(prop.getProperty("Issuedto"));
			book.setLib(lib);

			books.add(book);

		}

		return books;

	}
}