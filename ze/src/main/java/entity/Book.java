package entity;

import java.io.IOException;

import Update.IUpdater;

public class Book {
	private String index;
	private String author;
	private String nameBook;
	private String issued;
	private String issuedto;
	private String numberString;
	private String libName;
	private IUpdater updater;

	public String getIndex() {
		return index;
	}

	public IUpdater getUpdater() {
		return updater;
	}

	public void setUpdater(IUpdater updater) {
		this.updater = updater;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}

	public String getIssuedto() {
		return issuedto;
	}

	public void setIssuedto(String issuedto) {
		this.issuedto = issuedto;
	}

	public String getNumberString() {
		return numberString;
	}

	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}



	public String toString() {

		return String.format("[Ind=%s, Author=%s, NameBook=%s, Issued=%s, Issuedto=%s, Lib=%s]", index, author,
				nameBook, issued, issuedto, libName);
	}

	public void update() throws IOException {
		updater.update(this);
	}

}
