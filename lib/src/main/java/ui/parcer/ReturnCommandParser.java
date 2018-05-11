package ui.parcer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.search.ReturnSearchParam;

public class ReturnCommandParser {
	private final static Pattern p1 = Pattern.compile("id=<([^>]+)>");

	public ReturnSearchParam parseParams(String command) {
		ReturnSearchParam returnSearchParam = new ReturnSearchParam();
		Scanner in = new Scanner(System.in);

		Matcher m1 = p1.matcher(command);
		m1.find();
		try {
			String id = m1.group(1);
			returnSearchParam.setId(id);
		} catch (IllegalStateException e) {
		}
		return returnSearchParam;

	}

}
