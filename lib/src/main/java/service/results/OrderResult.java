package service.results;

public class OrderResult {
	private boolean isBookRented;
	private boolean isFound;
	private String issued;
	private String issuedto;
	
	public boolean isBookRented() {
		return isBookRented;
	}
	public void setBookRented(boolean isBookRented) {
		this.isBookRented = isBookRented;
	}
	public boolean isFound() {
		return isFound;
	}
	public void setFound(boolean isFound) {
		this.isFound = isFound;
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
