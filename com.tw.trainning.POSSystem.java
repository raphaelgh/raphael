package com.tw.trainning;

/**
 * The whole supermarket checkout system 
 * @author hp
 *
 */

public class POSSystem 
{
	private static Cart ds = null;
	private static Transfer tsf = null;
	private static Printer printer = null;
	static
	{
		ds = new Cart();
		tsf = new Transfer();
		printer = new Printer();
	}
	
	public static void printInventory()
	{		
		printer.printToConsole(tsf.transfer(ds.list()));
		printer.printToFile(tsf.transfer(ds.list()));
	}
	
	public static void main(String[] args)
	{
		printInventory();
	}
}
