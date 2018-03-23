package control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;

public class UserPan {
	Map<Pattern, IExecutor> mapCommand = new HashMap();

	public UserPan(List<Book> books) {
		Pattern p1 = Pattern.compile("FIND \\[author=<[^>]+>\\] \\[name=<[^>]+>\\]");
		mapCommand.put(p1, new Find(books));

		Pattern p2 = Pattern.compile("ORDER id=<[^>]+> abonent=<[^>]+>");
		mapCommand.put(p2, new Order(books));

		Pattern p3 = Pattern.compile("RETURN id=<[^>]+>");
		mapCommand.put(p3, new Return(books));
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		
		outer: while (true) {

			String command = in.nextLine();

			if (command.equals("EXIT"))
				return;

			for (Map.Entry entry : mapCommand.entrySet()) {

				Pattern p = (Pattern) entry.getKey();
				Matcher m = p.matcher(command);

				if (m.lookingAt()) {
					IExecutor comm = (IExecutor) entry.getValue();
					comm.execute(command);
					continue outer;
				}

			}
			System.out.println("Command is missing");
		}
	}

}
