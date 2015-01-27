package com.tw.trainning.testcase;

import org.junit.Assert;
import org.junit.Test;

import com.tw.trainning.Cart;

public class TestCart {

	Cart ds = new Cart();
	@Test
	public void test() 
	{
		Assert.assertArrayEquals(ds.getItems(), ds.list().toArray());
		System.out.println(ds.list());
	}

}
