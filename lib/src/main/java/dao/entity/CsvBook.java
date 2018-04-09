package dao.entity;

public class CsvBook extends AbstractBook{
	public CsvBook(){
		
	}
	
	public CsvBook(String index, String author, String nameBook, String issued, String issuedto, AbstractLib lib) {
		super(index, author, nameBook, issued, issuedto, lib);
		// TODO Auto-generated constructor stub
	}

	private String numberString;
	private String directory;

	public String getNumberString() {
		return numberString;
	}

	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
}
