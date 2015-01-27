package com.tw.trainning.testcase;

import junit.framework.TestCase;

import org.junit.Test;

import com.tw.trainning.Rule;

public class TestRule extends TestCase
{
	Rule rule = null;
	@Test
	public void test() 
	{
		double price = 3.0;
		int promotion = 3;
		String name = "菠萝";
		String unit = "个";
		rule = new Rule(price, promotion, name, unit);
		assertEquals(price, rule.price());
		assertEquals(promotion, rule.promotion());
		assertEquals(name, rule.name());
		assertEquals(unit, rule.unit());
		System.out.println(rule.toString());
	}

}
