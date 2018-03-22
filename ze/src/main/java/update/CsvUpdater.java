package update;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.opencsv.CSVReader;

import entity.Book;

public class CsvUpdater implements IUpdater {
	String directory;

	public CsvUpdater(String directory) {
		this.directory = directory;
	}

	public void update(Book book) throws IOException {
		CSVReader reader;

		reader = new CSVReader(new FileReader(directory), ',');

		List<String[]> records;

		records = reader.readAll();
		String id = book.getIndex();
		String author = book.getAuthor();
		String bookName = book.getNameBook();
		String issued = book.getIssued();
		String issuedto = book.getIssuedto();

		String[] bookParam = { id, author, bookName, issued, issuedto };

		String[] lastString = records.get(Integer.parseInt(book.getNumberString()));
		//подменяю, потому что не могу сделать remove, при remove в файле собется позици всех строк, а они у нас фиксированы для каждой книги
		lastString = bookParam;

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

		PrintWriter pw = new PrintWriter(new File("D:\\Central_Library\\lib1\\text.csv"));
		pw.write(builder.toString());
		pw.close();

		reader.close();

	}

}
