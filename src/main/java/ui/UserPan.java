package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.api.IResult;
import ui.api.IBox;
import ui.api.ICommandExecutor;
import ui.api.IDemonstrator;
import ui.box.FindBox;
import ui.box.OrderBox;
import ui.box.ReturnBox;

public class UserPan {
	private Map<Pattern, IBox> mapCommand = new HashMap();
	private final static Scanner in = new Scanner(System.in);

	public UserPan() {
		Pattern p1 = Pattern.compile("FIND ");
		mapCommand.put(p1, new FindBox());

		Pattern p2 = Pattern.compile("ORDER ");
		mapCommand.put(p2, new OrderBox());

		Pattern p3 = Pattern.compile("RETURN ");
		mapCommand.put(p3, new ReturnBox());
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

			for (Map.Entry<Pattern, IBox> entry : mapCommand.entrySet()) {

				Pattern p = entry.getKey();
				Matcher m = p.matcher(command);

				if (m.lookingAt()) {					
					IBox box = entry.getValue();
					IResult result = box.getCommandExecutor().execute(command);
					IDemonstrator demonstrator = box.getDemonstrator();
					demonstrator.showResult(result);
					isCommandFound = true;
					break;
				}

			}

			if (!isCommandFound) {
				System.out.println("Command is missing");
			}
		}
	}

}
