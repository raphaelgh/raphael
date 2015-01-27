package com.tw.trainning;


/**
 * This is the supermarket shop item to print
 * @author hp
 *
 */
public class Item 
{
	private String name;
	private int count;
	private double price;
	private double total;
	private int promotionCount;
	private String unit;
	
	public Item(String n, int c, double p, double t, int pc, String u)
	{
		name = n;
		count = c;
		price = p;
		total = t;
		promotionCount = pc;
		unit = u;
	}
	
	public String name()
	{
		return name;
	}
	
	public int count()
	{
		return count;
	}
	
	public double price()
	{
		return price;
	}
	
	public double total()
	{
		return total;
	}
	
	public int promotionCount()
	{
		return promotionCount;
	}
	
	public String unit()
	{
		return unit;
	}
	
	public String toString()
	{
		StringBuffer sBuf = new StringBuffer();
		sBuf.append("name: ").append(name);
		sBuf.append(", count: ").append(count);
		sBuf.append(", price: ").append(price);
		sBuf.append(", total price: ").append(total);
		sBuf.append(", promotion count: ").append(promotionCount);
		sBuf.append(", unit: ").append(unit);
		return sBuf.toString();
	}
}
