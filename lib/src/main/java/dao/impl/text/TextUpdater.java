package dao.impl.text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import dao.entity.AbstractBook;
import dao.entity.TextBook;

public class TextUpdater {

	public static void update(AbstractBook book) throws IOException {

		String directory = ((TextBook) book).getDirectory();
		Properties props = new Properties();

		props.setProperty("Index", book.getIndex());
		props.setProperty("Author", book.getAuthor());
		props.setProperty("Name", book.getNameBook());
		props.setProperty("Issued", book.getIssued());
		props.setProperty("Issuedto", book.getIssuedto());

		FileOutputStream out;

		out = new FileOutputStream(directory);

		props.store(out, null);

		out.close();

	}

}
