package com.tw.trainning;

/**
 * This is the rule between input and output
 * @author hp
 *
 */

public class Rule 
{
	private double price = 0;
	private int promotion = 0;
	private String name;	
	private String unit;
	
	public Rule(double p, int pro, String n, String u)
	{
		price = p;
		promotion = pro;
		name = n;
		unit = u;
	}
	
	public double price()
	{
		return price;
	}
	
	public int promotion()
	{
		return promotion;
	}
	
	public String name()
	{
		return name;
	}
	
	public String unit()
	{
		return unit;
	}
	
	public String toString()
	{
		StringBuffer sBuf = new StringBuffer();
		sBuf.append("price: ").append(price);
		sBuf.append(", promotion: ").append(promotion);
		sBuf.append(", name: ").append(name);
		sBuf.append(", unit: ").append(unit);
		return sBuf.toString();
	}
}
