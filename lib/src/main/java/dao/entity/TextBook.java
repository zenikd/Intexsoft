package dao.entity;

public class TextBook extends AbstractBook{
	public TextBook(){
		
	}
	
	public TextBook(String index, String author, String nameBook, String issued, String issuedto, AbstractLib lib) {
		super(index, author, nameBook, issued, issuedto, lib);
		// TODO Auto-generated constructor stub
	}

	private String directory;

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
}
