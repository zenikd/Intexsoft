package dao.entity;

import dao.api.IBook;
import dao.api.ILib;

public class Book implements IBook{
	
	private String index;
	public Book(String index, String directory) {
		super();
		this.index = index;
		this.directory = directory;
	}
	private String author;
	private String nameBook;
	private String issued;
	private String issuedto;
	private ILib lib;
	private String directory;
	
	
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public ILib getLib() {
		return lib;
	}
	public void setLib(ILib lib) {
		this.lib = lib;
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
