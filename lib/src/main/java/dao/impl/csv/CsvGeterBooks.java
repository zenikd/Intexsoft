package dao.impl.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import dao.entity.AbstractBook;
import dao.entity.AbstractLib;
import dao.entity.CsvBook;
import dao.entity.CsvLib;

public class CsvGeterBooks {

	public static List<AbstractBook> getBooks(AbstractLib lib) throws IOException {
		String directory = ((CsvLib) lib).getDirectory();

		CSVReader reader;

		reader = new CSVReader(new FileReader(directory), ',');

		List<AbstractBook> books = new ArrayList();

		List<String[]> records;

		records = reader.readAll();

		Iterator<String[]> iterator = records.iterator();

		iterator.next();

		for (Integer i = 0; i < records.size(); i++) {
			String[] record = records.get(i);

			CsvBook book = new CsvBook();
			book.setIndex(record[0]);
			book.setAuthor(record[1]);
			book.setNameBook(record[2]);
			book.setIssued(record[3]);
			book.setIssuedto(record[4]);
			book.setLib(lib);
			book.setNumberString(i.toString());			
			books.add(book);

		}

		reader.close();

		return books;

	}

}
