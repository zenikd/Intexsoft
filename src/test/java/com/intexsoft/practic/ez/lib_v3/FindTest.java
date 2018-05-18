package com.intexsoft.practic.ez.lib_v3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.result.FindCommandResult;

public class FindTest extends AbstractTest {

	@Test
	public void testSuccessCsv() {
		String author = "Gilson";
		String nameBook = "JAVA";

		FindCommandResult findCommandResult = findCommand(author, nameBook);
		assertEquals(findCommandResult.getBooks().get(0).getAuthor(), "Gilson");
		assertEquals(findCommandResult.getBooks().get(0).getNameBook(), "JAVA");

	}


	@Test
	public void testNotFound() {
		String author = getRandomPrefix();
		String nameBook = getRandomPrefix();

		FindCommandResult findCommandResult = findCommand(author, nameBook);
		assertEquals(findCommandResult.isFounded(), false);

	}

	@Test
	public void testSuccessTxtAuthor() {
		String author = "Asimov";
		String nameBook = "Foundation";

		FindCommandResult findCommandResult = findCommand(author, nameBook);
		assertEquals(findCommandResult.getBooks().get(0).getAuthor(), "Asimov");
		assertEquals(findCommandResult.getBooks().get(0).getNameBook(), "Foundation");

	}
	


}
