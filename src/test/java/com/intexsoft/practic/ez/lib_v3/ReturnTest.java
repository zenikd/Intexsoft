package com.intexsoft.practic.ez.lib_v3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.result.ReturnResult;

public class ReturnTest extends AbstractTest {

	@Test
	public void testSuccess() {
		for (Integer id = 1000; id < 1005; id++) {
			String issuedto = getRandomPrefix();
			returnCommand(id.toString());

			orderCommand(id.toString(), issuedto);
			ReturnResult returnResult = returnCommand(id.toString());

			assertEquals(returnResult.getIssuedto(), issuedto);

		}
	}

	@Test
	public void testReturnedEarly() {
		for (Integer id = 1000; id < 1005; id++) {
			String issuedto = getRandomPrefix();
			returnCommand(id.toString());

			ReturnResult returnResult = returnCommand(id.toString());

			assertEquals(returnResult.isReturnedEarly(), true);

		}
	}

	@Test
	public void testNotFound() {
		Integer id = -getRandomObjectsCount();
		String issuedto = getRandomPrefix();
		returnCommand(id.toString());

		ReturnResult returnResult = returnCommand(id.toString());

		assertEquals(returnResult.isFounded(), false);

	}
}
