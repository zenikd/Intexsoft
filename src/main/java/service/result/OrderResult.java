package service.result;

public class OrderResult extends BaseResult{
	private boolean bookRented;
	private boolean problemWithUpdate;
	private boolean moreThanOne;
	private String issued;
	private String issuedto;
	public boolean isBookRented() {
		return bookRented;
	}
	public void setBookRented(boolean bookRented) {
		this.bookRented = bookRented;
	}
	public boolean isProblemWithUpdate() {
		return problemWithUpdate;
	}
	public void setProblemWithUpdate(boolean problemWithUpdate) {
		this.problemWithUpdate = problemWithUpdate;
	}
	public boolean isMoreThanOne() {
		return moreThanOne;
	}
	public void setMoreThanOne(boolean moreThanOne) {
		this.moreThanOne = moreThanOne;
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
