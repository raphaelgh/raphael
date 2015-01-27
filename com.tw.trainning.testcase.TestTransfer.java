package com.tw.trainning.testcase;

import java.util.*;

import junit.framework.TestCase;

import org.junit.Test;

import com.tw.trainning.Cart;
import com.tw.trainning.Item;
import com.tw.trainning.Transfer;

public class TestTransfer extends TestCase
{
	@Test
	public void test() 
	{
		Cart ds = new Cart();
		Transfer tsf = new Transfer();
		List<Item> items = tsf.transfer(ds.list());
		Set<String> set = new HashSet<String>(ds.list());
		assertEquals(set.size(), items.size());
		for(Item item : items)
		{
			System.out.println(item);
		}
	}
}
