package ui.parcer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import service.search.OrderSearchParam;

public class OrderCommandParser {
	private final static Pattern p1 = Pattern.compile("id=<([^>]+)>");
	private final static Pattern p2 = Pattern.compile("abonent=<([^>]+)>");

	public OrderSearchParam parseParams(String command) {
		OrderSearchParam orderSearchParam = new OrderSearchParam();
		Matcher m1 = p1.matcher(command);
		m1.find();
		try {
			String id = m1.group(1);
			orderSearchParam.setId(id);
		} catch (IllegalStateException e) {

		}

		Matcher m2 = p2.matcher(command);

		m2.find();
		try {
			String issuedto = m2.group(1);
			orderSearchParam.setIssuedto(issuedto);
		} catch (IllegalStateException e) {

		}

		return orderSearchParam;
	}
}
