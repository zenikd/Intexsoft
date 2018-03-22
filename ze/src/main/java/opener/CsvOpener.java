package opener;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import entity.Book;
import entity.Lib;
import update.CsvUpdater;

public class CsvOpener implements IOpener {
	Lib lib;

	public CsvOpener(Lib lib) {
		this.lib = lib;

	}

	public void open(List<Book> books) throws IOException {
		String directory = lib.getDirectories().get(0);

		CSVReader reader;

		reader = new CSVReader(new FileReader(directory), ',');

		List<String[]> records;

		records = reader.readAll();

		Iterator<String[]> iterator = records.iterator();

		iterator.next();

		for (Integer i = 0; i < records.size(); i++) {
			String[] record = records.get(i);

			Book book = new Book();
			book.setIndex(record[0]);
			book.setAuthor(record[1]);
			book.setNameBook(record[2]);
			book.setIssued(record[3]);
			book.setIssuedto(record[4]);
			book.setLibName(lib.getName());
			book.setNumberString(i.toString());
			book.setUpdater(new CsvUpdater(directory));

			books.add(book);

		}

		reader.close();

	}

}
