package dao.impl.txt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.api.IBookDao;
import dao.api.IBook;
import dao.api.IBookType;
import dao.api.ILib;
import dao.type.book.TxtTypeBooks;

public class TxtBookDaoImpl implements IBookDao {

	public IBookType getById(String id, List<ILib> libs) {

		List<IBook> listBook = new ArrayList();

		for (ILib lib : libs) {
			List<IBook> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = TxtGeterBooks.getBooks(lib);

				for (IBook book : notCheckedBooks) {
					if (book.getIndex().equals(id)) {
						listBook.add(book);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return new TxtTypeBooks(listBook);
	}

	public List<IBook> findCommand(String author, String nameBook, List<ILib> libs) {
		List<IBook> foundBooks = new ArrayList<IBook>();

		Pattern searchAuthor = Pattern.compile(author);
		Pattern serachNameBook = Pattern.compile(nameBook);

		for (ILib lib : libs) {
			List<IBook> notCheckedBooks = new ArrayList();

			try {
				notCheckedBooks = TxtGeterBooks.getBooks(lib);

				for (IBook book : notCheckedBooks) {
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

	public void update(List<IBook> books) throws IOException {
		for (IBook book : books)

			TxtUpdater.update(book);

	}

}
