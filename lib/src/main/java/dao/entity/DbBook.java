package dao.entity;

public class DbBook extends AbstractBook{
	public DbBook(){
		
	}

	public DbBook(String index, String author, String nameBook, String issued, String issuedto, AbstractLib lib) {
		super(index, author, nameBook, issued, issuedto, lib);
		// TODO Auto-generated constructor stub
	}

}
