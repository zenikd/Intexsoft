package dao.impl.text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import dao.entity.AbstractBook;
import dao.entity.TextBook;

public class TextUpdater {

	public static void update(AbstractBook book) {

		String directory = ((TextBook) book).getDirectory();
		Properties props = new Properties();

		props.setProperty("Index", book.getIndex());
		props.setProperty("Author", book.getAuthor());
		props.setProperty("Name", book.getNameBook());
		props.setProperty("Issued", book.getIssued());
		props.setProperty("Issuedto", book.getIssuedto());

		FileOutputStream out;

		try {
			out = new FileOutputStream(directory);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try {
			props.store(out, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}

}
