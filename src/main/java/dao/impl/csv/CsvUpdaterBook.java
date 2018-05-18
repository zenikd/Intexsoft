package dao.impl.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.opencsv.CSVReader;

import dao.api.IBook;

public class CsvUpdaterBook {

	
	public static void update(IBook book) throws IOException {
		CSVReader reader;

		String directory = book.getDirectory();

		reader = new CSVReader(new FileReader(directory), ',');

		List<String[]> records;

		records = reader.readAll();
		String id = book.getIndex();
		String author = book.getAuthor();
		String bookName = book.getNameBook();
		String issued = book.getIssued();
		String issuedto = book.getIssuedto();

		String[] bookParam = { id, author, bookName, issued, issuedto };

		int numberString = -1;

		for (int i = 0; i < records.size(); i++) {
			String[] curentBook = records.get(i);
			if (curentBook[0].equals(id)) {
				numberString = i;
				break;
			}

		}

		if (numberString == -1) {
			throw new IOException();
		}

		records.set(numberString, bookParam);

		StringBuilder builder = new StringBuilder();

		for (String[] str : records) {
			builder.append(str[0]);
			builder.append(",");
			builder.append(str[1]);
			builder.append(",");
			builder.append(str[2]);
			builder.append(",");
			builder.append(str[3]);
			builder.append(",");
			builder.append(str[4]);
			builder.append('\n');
		}

		PrintWriter pw = new PrintWriter(new File(book.getDirectory()));
		pw.write(builder.toString());
		pw.close();

		reader.close();

	}

}