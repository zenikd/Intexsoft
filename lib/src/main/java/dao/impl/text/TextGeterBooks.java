package dao.impl.text;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.entity.AbstractBook;
import dao.entity.AbstractLib;
import dao.entity.TextLib;

public class TextGeterBooks {

	public static List<AbstractBook> getBooks(AbstractLib lib) throws IOException {
		List<String> directories = ((TextLib) lib).getDirectories();

		FileInputStream fileInputStream;

		List<AbstractBook> books = new ArrayList();

		for (String directory : directories) {
			Properties prop = new Properties();

			fileInputStream = new FileInputStream(directory);
			prop.load(fileInputStream);

			AbstractBook book = new AbstractBook();

			book.setIndex(prop.getProperty("Index"));
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