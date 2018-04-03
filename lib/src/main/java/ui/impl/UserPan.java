package ui.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.entity.AbstactLib;
import service.impl.AbstarctLiBService;
import ui.api.IShower;

public class UserPan {
	private Map<Pattern, IShower> mapCommand = new HashMap();

	public UserPan() {
		Pattern p1 = Pattern.compile("FIND \\[author=<[^>]*>\\] \\[name=<[^>]*>\\]");
		mapCommand.put(p1, new ShowerResultFind());

		Pattern p2 = Pattern.compile("ORDER id=<[^>]+> abonent=<[^>]+>");
		mapCommand.put(p2, new ShowerResultOrder());

		Pattern p3 = Pattern.compile("RETURN id=<[^>]+>");
		mapCommand.put(p3, new ShowerResultReturn());
	}

	public void start(List<AbstarctLiBService> libServices) {
		Scanner in = new Scanner(System.in);

		outer: while (true) {

			String command = in.nextLine();

			if (command.equals("EXIT"))
				return;

			for (Map.Entry<Pattern, IShower> entry : mapCommand.entrySet()) {

				Pattern p = entry.getKey();
				Matcher m = p.matcher(command);

				if (m.lookingAt()) {
					IShower shower = entry.getValue();
					shower.show(libServices, command);
					continue outer;
				}

			}
			System.out.println("Command is missing");
		}
	}

}
