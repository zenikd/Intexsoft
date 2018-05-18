package com.intexsoft.practic.ez.lib_v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import service.result.FindCommandResult;
import service.result.OrderResult;
import service.result.ReturnResult;

public class OrderTest extends AbstractTest {

	@Test
	public void testOrderSuccess() {
		for (Integer id = 1000; id < 1005; id++) {
			returnCommand(id.toString());
			String issuedto = getRandomPrefix();
			OrderResult orderResult = orderCommand(id.toString(), issuedto);
			assertEquals(orderResult.getIssuedto(), issuedto);
			assertNotNull(orderResult.getIssued());
		}
	}
	
	@Test
	public void testOrderReserved() {
		for (Integer id = 1000; id < 1005; id++) {	
			returnCommand(id.toString());
			
			String issuedto = getRandomPrefix();
			orderCommand(id.toString(), issuedto);
			OrderResult orderResult = orderCommand(id.toString(), issuedto);
			assertEquals(orderResult.isBookRented(), true);
			assertEquals(orderResult.getIssuedto(), issuedto);
		}
	}

	@Test
	public void testNotFound() {
		Integer id = -getRandomObjectsCount();
		String issuedto = getRandomPrefix();
		orderCommand(id.toString(), issuedto);

		ReturnResult returnResult = returnCommand(id.toString());

		assertEquals(returnResult.isFounded(), false);

	}
	
	

}
