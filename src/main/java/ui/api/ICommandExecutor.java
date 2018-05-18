package ui.api;

import service.api.IResult;

public interface ICommandExecutor {
	IResult execute(String command);
}
