package dao.impl.txt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import dao.api.IBook;

public class TxtUpdater {

	public static void update(IBook book) throws IOException {

		String directory = book.getDirectory();
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