package com.tw.trainning.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tw.trainning.Cart;
import com.tw.trainning.Item;
import com.tw.trainning.Printer;
import com.tw.trainning.Transfer;

public class TestPrinterToConsole 
{

	@Test
	public void test() 
	{
		Cart ds = new Cart();
		Transfer tsf = new Transfer();
		List<Item> items = tsf.transfer(ds.list());
		assertEquals(items.size(), items.size());
		Printer printer = new Printer();
		printer.printToConsole(items);
	}

}
