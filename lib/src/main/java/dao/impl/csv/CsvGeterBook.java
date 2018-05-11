package dao.impl.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import dao.entity.AbstractBook;
import dao.entity.AbstractLib;
import dao.entity.csv.CsvBook;
import dao.entity.csv.CsvLib;

public class CsvGeterBook {

	public static List<AbstractBook> getBooks(AbstractLib lib) throws IOException {
		String libDirectory = ((CsvLib) lib).getDirectory();
		
		File file = new File(libDirectory);
		File[] files = file.listFiles();
		List<AbstractBook> books = new ArrayList();
		 
		
		for(File dir: files){
		String booksDirectory = dir.toString();
			
		CSVReader reader;
		reader = new CSVReader(new FileReader(booksDirectory), ',');
		
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
			book.setNumberString(i.toString());	
			book.setDirectory(booksDirectory);
			book.setAbstractLib(lib);
			books.add(book);

		}

		reader.close();
		}
		return books;

	}

}