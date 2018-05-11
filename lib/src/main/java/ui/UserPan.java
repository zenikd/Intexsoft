package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.api.ICommandExecutor;
import ui.command.FindCommand;
import ui.command.OrderCommand;
import ui.command.ReturnCommand;

public class UserPan {
	private Map<Pattern, ICommandExecutor> mapCommand = new HashMap();
	private final static Scanner in = new Scanner(System.in);

	public UserPan() {
		Pattern p1 = Pattern.compile("FIND ");
		mapCommand.put(p1, new FindCommand());

		Pattern p2 = Pattern.compile("ORDER ");
		mapCommand.put(p2, new OrderCommand());

		Pattern p3 = Pattern.compile("RETURN ");
		mapCommand.put(p3, new ReturnCommand());
	}

	/**
	 * 
	 * @param libServices
	 *            the list lib service
	 */

	public void start() {

		while (true) {

			String command = in.nextLine();

			if (command.equals("EXIT"))
				return;

			boolean isCommandFound = false;

			for (Map.Entry<Pattern, ICommandExecutor> entry : mapCommand.entrySet()) {

				Pattern p = entry.getKey();
				Matcher m = p.matcher(command);

				if (m.lookingAt()) {					
					ICommandExecutor executor = entry.getValue();
					executor.execute(command);	
					isCommandFound = true;
				}

			}

			if (!isCommandFound) {
				System.out.println("Command is missing");
			}
		}
	}

}
