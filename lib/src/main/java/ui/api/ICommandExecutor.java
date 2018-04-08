package ui.api;

import java.util.List;

import service.impl.AbstractLiBService;

public interface ICommandExecutor {
	public void  execute(List<AbstractLiBService> libServices, String command);
}
