package dao.impl.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.api.IBookDao;
import dao.entity.AbstractBook;
import dao.entity.AbstractLib;
import dao.impl.csv.CsvGeterBooks;
import dao.impl.csv.CsvUpdater;
import service.impl.AbstarctLiBService;
import service.impl.AbstractBookService;
import service.impl.TextBookService;

public class TextBookDaoImpl implements IBookDao {
	public void getBookById(String id, AbstarctLiBService libService, List<AbstractBookService> bookServices)  {

		List<AbstractLib> libs = libService.getLibs();
		
		TextBookService textBookService = new TextBookService();

		for (AbstractLib lib : libs) {
			List<AbstractBook> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = TextGeterBooks.getBooks(lib);

				for (AbstractBook book : notCheckedBooks) {
					if (book.getIndex().equals(id)) {
						textBookService.addBook(book);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		bookServices.add(textBookService);
	}

	public void findCommand(String author, String nameBook, AbstarctLiBService libService,
			List<AbstractBook> foundBooks) {
		List<AbstractLib> libs = libService.getLibs();

		for (AbstractLib lib : libs) {
			List<AbstractBook> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = TextGeterBooks.getBooks(lib);

				Pattern searchAuthor = Pattern.compile(author);
				Pattern serachNameBook = Pattern.compile(nameBook);

				for (AbstractBook book : notCheckedBooks) {
					Matcher m1 = searchAuthor.matcher(book.getAuthor());
					Matcher m2 = serachNameBook.matcher(book.getNameBook());

					if (m1.lookingAt() && m2.lookingAt()) {
						foundBooks.add(book);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	@Override
	public void update(AbstractBook book) throws IOException {
		TextUpdater textUpdater = new TextUpdater(directory);
		TextUpdater.update(book);
		
	}

}
