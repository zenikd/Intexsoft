package ui.parcer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.search.FindSearchParam;

public class FindCommandParser {
	private final static Pattern p1 = Pattern.compile("author=<([^>]+)>");
	private final static Pattern p2 = Pattern.compile("name=<([^>]+)>");

	public FindSearchParam parseParams(String command) {
		FindSearchParam findSearchParam = new FindSearchParam();

		Matcher m1 = p1.matcher(command);
		if (m1.find()) {
			String author = m1.group(1);
			findSearchParam.setAuthor(author);
		} else {
			findSearchParam.setAuthor("");
		}

		Matcher m2 = p2.matcher(command);
		if (m2.find()) {
			String nameBook = m2.group(1);
			findSearchParam.setNameBook(nameBook);
		} else {
			findSearchParam.setNameBook("");
		}

		return findSearchParam;

	}
}
