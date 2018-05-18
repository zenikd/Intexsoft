package dao.api;

public interface IBook {
	 ILib getLib();
	 void setLib(ILib abstractLib) ;
	 String getIndex();
	 void setIndex(String index);
	 String getAuthor();
	 void setAuthor(String author);
	 String getNameBook();
	 void setNameBook(String nameBook);
	 String getIssued();
	 void setIssued(String issued);
	 String getIssuedto();
	 void setIssuedto(String issuedto);
	 public String getDirectory();		
	public void setDirectory(String directory);
	
}
