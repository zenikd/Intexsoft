package ui.box;

import ui.api.IBox;
import ui.api.ICommandExecutor;
import ui.api.IDemonstrator;
import ui.command.ReturnCommandExecutor;
import ui.demonstrator.ReturnDemonstrator;

public class ReturnBox implements IBox{
	private IDemonstrator demonstrator = new ReturnDemonstrator();
	private ICommandExecutor commandExecutor = new ReturnCommandExecutor();
	public IDemonstrator getDemonstrator() {
		return demonstrator;
	}
	public void setDemonstrator(IDemonstrator demonstrator) {
		this.demonstrator = demonstrator;
	}
	public ICommandExecutor getCommandExecutor() {
		return commandExecutor;
	}
	public void setCommandExecutor(ICommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

}
