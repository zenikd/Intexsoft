package dao.impl.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.opencsv.CSVReader;

import dao.entity.AbstractBook;
import dao.entity.csv.CsvBook;

public class CsvUpdaterBook {

	public static void update(AbstractBook book) throws IOException {
		CSVReader reader;

		CsvBook csvBook = (CsvBook) book;
		
		String directory = csvBook.getDirectory();

		reader = new CSVReader(new FileReader(directory), ',');

		List<String[]> records;

		records = reader.readAll();
		String id = csvBook.getIndex();
		String author = csvBook.getAuthor();
		String bookName = csvBook.getNameBook();
		String issued = csvBook.getIssued();
		String issuedto = csvBook.getIssuedto();

		String[] bookParam = { id, author, bookName, issued, issuedto };

		String[] lastString = records.get(Integer.parseInt(csvBook.getNumberString()));
		/* подменяю, потому что не могу сделать remove, при remove в файле собется
		 позици всех строк, а они у нас фиксированы для каждой книги */
		records.set(Integer.parseInt(csvBook.getNumberString()), bookParam);

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

		PrintWriter pw = new PrintWriter(new File(csvBook.getDirectory()));
		pw.write(builder.toString());
		pw.close();

		reader.close();

	}

}