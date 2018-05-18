package ui.api;

public interface IBox {
	public IDemonstrator getDemonstrator();
	public void setDemonstrator(IDemonstrator demonstrator);
	public ICommandExecutor getCommandExecutor();
	public void setCommandExecutor(ICommandExecutor commandExecutor);

}
