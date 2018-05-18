package ui.box;

import ui.api.IBox;
import ui.api.ICommandExecutor;
import ui.api.IDemonstrator;
import ui.command.FindCommandExecutor;
import ui.command.OrderCommandExecutor;
import ui.demonstrator.FindDemonstrator;
import ui.demonstrator.OrderDemonstrator;

public class OrderBox implements IBox{
	private IDemonstrator demonstrator = new OrderDemonstrator();
	private ICommandExecutor commandExecutor = new OrderCommandExecutor();
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
