package dao.entity;

import java.sql.Date;

public class AbstractBook {
	private String index;
	private String author;
	private String nameBook;
	private String issued;
	private String issuedto;
	private AbstractLib lib;
	
	public AbstractBook(){
		
	}
	
	/**
	 * 
	 * @param index
	 *            the id or index book
	 * @param author
	 *            the name author
	 * @param nameBook
	 *            the name book
	 * @param issued
	 *            the date order
	 * @param issuedto
	 *            the name issuedto
	 * @param lib
	 *            the library where the book located
	 */
	
	public AbstractBook(String index, String author, String nameBook, String issued, String issuedto, AbstractLib lib ){
		this.index = index;
		this.author = author;
		this.nameBook = nameBook;
		this.issued = issued;
		this.issuedto = issuedto;
	}

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
