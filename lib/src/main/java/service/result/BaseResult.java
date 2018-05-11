package service.result;

public class BaseResult {	
	private boolean errorCommand;
	private boolean founded;
	public boolean isErrorCommand() {
		return errorCommand;
	}
	public void setErrorCommand(boolean errorCommand) {
		this.errorCommand = errorCommand;
	}
	public boolean isFounded() {
		return founded;
	}
	public void setFounded(boolean founded) {
		this.founded = founded;
	}
	
	
}
