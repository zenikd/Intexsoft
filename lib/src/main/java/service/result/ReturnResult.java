package service.result;

public class ReturnResult extends BaseResult{
	private boolean moreThanOne;
	private boolean returnedEarly;
	private boolean problemWithUpdate;
	private String issuedto;
	public boolean isMoreThanOne() {
		return moreThanOne;
	}
	public void setMoreThanOne(boolean moreThanOne) {
		this.moreThanOne = moreThanOne;
	}
	public boolean isReturnedEarly() {
		return returnedEarly;
	}
	public void setReturnedEarly(boolean returnedEarly) {
		this.returnedEarly = returnedEarly;
	}
	public boolean isProblemWithUpdate() {
		return problemWithUpdate;
	}
	public void setProblemWithUpdate(boolean problemWithUpdate) {
		this.problemWithUpdate = problemWithUpdate;
	}
	public String getIssuedto() {
		return issuedto;
	}
	public void setIssuedto(String issuedto) {
		this.issuedto = issuedto;
	}
	
	
}