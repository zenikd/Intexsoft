package ui.box;

import ui.api.IBox;
import ui.api.ICommandExecutor;
import ui.api.IDemonstrator;
import ui.command.FindCommandExecutor;
import ui.demonstrator.FindDemonstrator;

public class FindBox implements IBox{
	private IDemonstrator demonstrator = new FindDemonstrator();
	private ICommandExecutor commandExecutor = new FindCommandExecutor();

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
