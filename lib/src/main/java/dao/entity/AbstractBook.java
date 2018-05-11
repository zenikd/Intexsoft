package dao.entity;

public class AbstractBook {
	private String index;
	private String author;
	private String nameBook;
	private String issued;
	private String issuedto;
	private AbstractLib abstractLib;
	
	
	public AbstractLib getAbstractLib() {
		return abstractLib;
	}
	public void setAbstractLib(AbstractLib abstractLib) {
		this.abstractLib = abstractLib;
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
}