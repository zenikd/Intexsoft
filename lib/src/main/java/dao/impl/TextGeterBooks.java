package dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.api.IGeterBooks;
import dao.entity.Book;
import dao.entity.AbstactLib;

public class TextGeterBooks implements IGeterBooks {

	public List<Book> getBooks(AbstactLib lib) throws IOException {
		List<String> directories = lib.getDirectories();

		FileInputStream fileInputStream;
		
		List<Book> books = new ArrayList();

		for (String directory : directories) {
			Properties prop = new Properties();

			fileInputStream = new FileInputStream(directory);
			prop.load(fileInputStream);

			Book book = new Book();

			book.setIndex(prop.getProperty("Index"));
			book.setAuthor(prop.getProperty("Author"));
			book.setNameBook(prop.getProperty("Name"));
			book.setIssued(prop.getProperty("Issued"));
			book.setIssuedto(prop.getProperty("Issuedto"));
			book.setLibName(lib.getName());
			book.setUpdater(new TextUpdater(directory));

			books.add(book);

		}
		
		return books;

	}
}