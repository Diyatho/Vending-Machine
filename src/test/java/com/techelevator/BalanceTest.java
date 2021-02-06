package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Balance;

public class BalanceTest {
	
	
	private Balance BalanceTest;
	
	
	@Test
	public void isValidAmountReturnTrue() {
		Assert.assertTrue(BalanceTest.isValidAmount("1"));
		Assert.assertTrue(BalanceTest.isValidAmount("2"));
		Assert.assertTrue(BalanceTest.isValidAmount("5"));
		Assert.assertTrue(BalanceTest.isValidAmount("10"));
		Assert.assertTrue(BalanceTest.isValidAmount("20"));
	}

}
