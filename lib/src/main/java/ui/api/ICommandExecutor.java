package ui.api;

import java.util.List;

import service.impl.AbstarctLiBService;

public interface ICommandExecutor {
	public void  execute(List<AbstarctLiBService> libServices, String command);
}
