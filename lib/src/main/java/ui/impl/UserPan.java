package ui.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.impl.AbstarctLiBService;
import ui.api.ICommandExecutor;

public class UserPan {
	private Map<Pattern, ICommandExecutor> mapCommand = new HashMap();

	public UserPan() {
		Pattern p1 = Pattern.compile("FIND \\[author=<[^>]*>\\] \\[name=<[^>]*>\\]");
		mapCommand.put(p1, new FindCommand());

		Pattern p2 = Pattern.compile("ORDER id=<[^>]+> abonent=<[^>]+>");
		mapCommand.put(p2, new OrderCommand());

		Pattern p3 = Pattern.compile("RETURN id=<[^>]+>");
		mapCommand.put(p3, new ReturnCommand());
	}

	public void start(List<AbstarctLiBService> libServices) {
		Scanner in = new Scanner(System.in);

		outer: while (true) {

			String command = in.nextLine();

			if (command.equals("EXIT"))
				return;

			for (Map.Entry<Pattern, ICommandExecutor> entry : mapCommand.entrySet()) {

				Pattern p = entry.getKey();
				Matcher m = p.matcher(command);

				if (m.lookingAt()) {
					ICommandExecutor executor = entry.getValue();
					executor.execute(libServices, command);
					continue outer;
				}

			}
			System.out.println("Command is missing");
		}
	}

}
