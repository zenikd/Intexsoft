package opener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import entity.Book;
import entity.Lib;
import update.TextUpdater;

public class TextOpener implements IOpener {
	Lib lib;

	public TextOpener(Lib lib) {
		this.lib = lib;

	}

	public void open(List<Book> books) throws IOException {
		List<String> directories = lib.getDirectories();

		FileInputStream fileInputStream;

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

	}
}