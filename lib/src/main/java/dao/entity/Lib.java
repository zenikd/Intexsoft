package dao.entity;

import java.io.IOException;
import java.util.List;

import dao.api.IGeterBooks;

public class Lib {
	private IGeterBooks geterBooks;
	private List<String> directories;
	private String name;

	public IGeterBooks getGeterBooks() {
		return geterBooks;
	}

	public void setGeterBooks(IGeterBooks geterBooks) {
		this.geterBooks = geterBooks;
	}

	public List<String> getDirectories() {
		return directories;
	}

	public void setDirectories(List<String> directories) {
		this.directories = directories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() throws IOException {
		return geterBooks.getBooks(this);
	}

}
