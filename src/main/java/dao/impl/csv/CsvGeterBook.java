package dao.impl.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import dao.api.IBook;
import dao.api.ILib;
import dao.entity.Book;

public class CsvGeterBook {

	public static List<IBook> getBooks(ILib lib) throws IOException {
		String libDirectory = lib.getDirectory();
		
		File file = new File(libDirectory);
		File[] files = file.listFiles();
		List<IBook> books = new ArrayList();
		 
		
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

			IBook book = new Book(record[0],booksDirectory);			
			book.setAuthor(record[1]);
			book.setNameBook(record[2]);
			book.setIssued(record[3]);
			book.setIssuedto(record[4]);		
			book.setLib(lib);
			books.add(book);

		}

		reader.close();
		}
		return books;

	}

}