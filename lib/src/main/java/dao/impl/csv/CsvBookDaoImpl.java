package dao.impl.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.api.AppSpecificallyBook;
import dao.api.IBookType;
import dao.api.ILibType;
import dao.entity.AbstractBook;
import dao.entity.AbstractLib;
import dao.type.book.CsvTypeBooks;

public class CsvBookDaoImpl implements AppSpecificallyBook{
	
	public IBookType getById(String id, ILibType libCollection )  {		
		
		List<AbstractLib> libs = libCollection.getLibs();
		
		CsvTypeBooks csvBookCollection = new CsvTypeBooks();

		for (AbstractLib lib : libs) {
			List<AbstractBook> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = CsvGeterBook.getBooks(lib);

				for (AbstractBook book : notCheckedBooks) {
					if (book.getIndex().equals(id)) {
						csvBookCollection.addBook(book);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return csvBookCollection;

	}

	public List<AbstractBook> findCommand(String author, String nameBook, ILibType libCollection) {
		List<AbstractBook> foundBooks = new ArrayList<AbstractBook>();
		
		List<AbstractLib> libs = libCollection.getLibs();

		for (AbstractLib lib : libs) {
			List<AbstractBook> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = CsvGeterBook.getBooks(lib);

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
		
		return foundBooks;

	}

	
	public void update(IBookType bookCollection) throws IOException {
		for(AbstractBook abstractBook: bookCollection.getBooks()) {			
			CsvUpdaterBook.update(abstractBook);			
		}
				
	}

	

	
	

}
