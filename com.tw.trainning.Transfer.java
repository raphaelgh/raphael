package com.tw.trainning;

import java.util.*;
/**
 * Transfer from the input to output under the rule
 * @author hp
 *
 */

public class Transfer 
{
	private int itemLength = 10;
	private Map<String, Rule> map = new HashMap<String, Rule>();
	
	public Transfer()
	{
		init();
	}
	
	/**
	 * if u like, u can read them from an xml file
	 */
	private void init()
	{
		Rule cokecoler = new Rule(3, 3, "可口可乐", "瓶");
		Rule badminton = new Rule(1, 5, "羽毛球", "个");
		Rule apple = new Rule(5.5, 0, "苹果", "斤");
		map.put("ITEM000001", badminton);
		map.put("ITEM000003", apple);
		map.put("ITEM000005", cokecoler);
	}
	
	public Map<String, Rule> transferMap()
	{
		return map;
	}
	
	public List<Item> transfer(List<String> source)
	{
		Map<String, Item> tempMap = new HashMap<String, Item>(); //bad, there should be more gentle
		for(String s : source)
		{
			String[] ss = s.length() > itemLength ? s.split("-") : new String[]{s};
			if(!map.containsKey(ss[0]))
			{
				continue;
			}
			int count = s.length() > itemLength ? Integer.parseInt(ss[1]) : 1;
			count = tempMap.containsKey(ss[0]) ? count + tempMap.get(ss[0]).count() : count;
			Rule rule = map.get(ss[0]);
			int promotion = rule.promotion() != 0 ? count/rule.promotion() : 0;
			//there should be improved to save memory
			Item item = new Item(rule.name(), count, rule.price(), (count-promotion)*rule.price(), promotion, rule.unit());
			tempMap.put(ss[0], item);
		}
		return new ArrayList<Item>(tempMap.values());
	}
}
