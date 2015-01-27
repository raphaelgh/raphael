package com.tw.trainning;

import java.util.*;
import java.io.*;

/**
 * This is the class to print the supermarket ticket
 * @author hp
 *
 */

public class Printer 
{
	private final String header = "***<没钱赚商店>购物清单***";
	private final String promotionHeader = "挥泪赠送商品：";
	private final String bar = "----------------------";
	private final String end = "**********************";
	private final String name = "名称：";
	private final String count = "数量：";
	private final String price = "单价：";
	private final String total = "小计：";
	private final String allPrice = "总计：";
	private final String save = "节省：";
	private final String unit = "(元)";
	private double totalPrice;
	private double savePrice;
	private String fileName = "items.html";
	private final String htmlBarBegin = "<p>";
	private final String htmlBarEnd = "</p>";
	private final String comma = "，";
	
	public Printer(String fn)
	{
		fileName = fn;
	}
	
	public Printer(){}
	
	/**
	 * Print the items to console
	 * @param itemList
	 */
	public void printToConsole(List<Item> itemList)
	{
		System.out.println(header);
		List<Item> promotionItemList = new ArrayList<Item>();
		for(Item item : itemList)
		{
			System.out.format("%s%s,%s%s%s,%s%s%s,%s%s%s%n", name, item.name(), count, item.count(),
					item.unit(), price, item.price(), unit, total, item.total(), unit);
			boolean flag = item.promotionCount() != 0 ? true : false;
			if(flag)
			{
				promotionItemList.add(item);				
			}
			totalPrice = item.total() + totalPrice;
		}		
		printPromotionList(promotionItemList);
		printPrice(totalPrice, savePrice);
	}
	
	//to compass the next function
	private String itemToString(Item item)
	{
		StringBuffer sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(name).append(item.name()).append(comma).append(count).append(item.count());
		sBuf.append(item.unit()).append(comma).append(price).append(item.price());
		sBuf.append(unit).append(comma).append(total).append(item.total()).append(unit);
		sBuf.append(htmlBarEnd);
		return sBuf.toString();
	}
	
	/**
	 * Print the items to file specified when Printer's initialization, 
	 * default file name is items.html
	 * @param itemList
	 */
	public void printToFile(List<Item> itemList)
	{
		File file = new File(fileName);
		BufferedWriter writer = null;
		try 
		{
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(header, 0, header.length());
			List<Item> promotionItemList = new ArrayList<Item>();
			for(Item item : itemList)
			{
				String s = itemToString(item);
				writer.write(s, 0, s.length());				
				boolean flag = item.promotionCount() != 0 ? true : false;
				if(flag)
				{
					promotionItemList.add(item);				
				}
				totalPrice = item.total() + totalPrice;
			}		
			printPromotionListToFile(promotionItemList, writer);
			printPriceToFile(totalPrice, savePrice, writer);		
			System.out.format("File path is %s%n", file.getAbsolutePath());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				writer.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}	
		}
	}
	
	//print the promotion items
	private void printPromotionList(List<Item> itemList)
	{
		System.out.println(bar);
		System.out.println(promotionHeader);
		for(Item promotionItem : itemList)
		{					
			System.out.format("%s%s,%s%s%s%n", name, promotionItem.name(),count, 
					promotionItem.promotionCount(), promotionItem.unit());
			savePrice = savePrice + promotionItem.promotionCount()*promotionItem.price();
		}
	}
	
	//print the promotion items to file
	private void printPromotionListToFile(List<Item> itemList, BufferedWriter writer) throws IOException
	{
		StringBuffer sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(bar).append(htmlBarEnd);
		writer.write(sBuf.toString(), 0, sBuf.toString().length());
		sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(promotionHeader).append(htmlBarEnd);
		writer.write(sBuf.toString(), 0, sBuf.toString().length());
		for(Item promotionItem : itemList)
		{
			sBuf = new StringBuffer();
			sBuf.append(htmlBarBegin).append(name).append(promotionItem.name()).append(comma).append(count);
			sBuf.append(promotionItem.promotionCount()).append(promotionItem.unit()).append(htmlBarEnd);
			writer.write(sBuf.toString(), 0, sBuf.toString().length());
			savePrice = savePrice + promotionItem.promotionCount()*promotionItem.price();
		}
	}
	
	//print the both total price and cutoff price
	private void printPrice(double tp, double sp)
	{
		System.out.println(bar);
		System.out.format("%s%s%s%n", allPrice, tp, unit);
		System.out.format("%s%s%s%n", save, sp, unit);
		System.out.println(end);
	}
	
	//print the both total price and cutoff price to file
	private void printPriceToFile(double tp, double sp, BufferedWriter writer) throws IOException
	{
		StringBuffer sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(bar).append(htmlBarEnd);
		writer.write(sBuf.toString(), 0, sBuf.toString().length());
		sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(allPrice).append(tp).append(unit).append(htmlBarEnd);
		writer.write(sBuf.toString(), 0, sBuf.toString().length());	
		sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(save).append(sp).append(unit).append(htmlBarEnd);
		writer.write(sBuf.toString(), 0, sBuf.toString().length());		
		sBuf = new StringBuffer();
		sBuf.append(htmlBarBegin).append(end).append(htmlBarEnd);
		writer.write(sBuf.toString(), 0, sBuf.toString().length());	
	}

}
