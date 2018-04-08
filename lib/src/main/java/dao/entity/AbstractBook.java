package dao.entity;

import java.sql.Date;

public class AbstractBook {
	private String index;
	private String author;
	private String nameBook;
	private String issued;
	private String issuedto;
	private AbstractLib lib;

	public String getIndex() {
		return index;
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

	public AbstractLib getLib() {
		return lib;
	}

	public void setLib(AbstractLib lib) {
		this.lib = lib;
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

	@Override
	public String toString() {

		return String.format("[Ind=%s, Author=%s, NameBook=%s, Issued=%s, Issuedto=%s]", index, author, nameBook,
				issued, issuedto);
	}

}
