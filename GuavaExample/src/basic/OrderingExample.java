package basic;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

class Item{
	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	Item(String aName, int aAge){
		name = aName;
		age = aAge;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", age=" + age + "]";
	}
	
}

public class OrderingExample {
	static void naturalTest(){
		List<Integer> unorderList = Lists.newArrayList(111,111,234,504,221,342);
		System.out.println("unorder : " + unorderList);
		System.out.println("order? :"+ Ordering.natural().isOrdered(unorderList));
		List<Integer> orderList =  Ordering.natural().sortedCopy(unorderList);
		System.out.println("order: "+ orderList);
		System.out.println("order? :" + Ordering.natural().isOrdered(orderList));
		
		
	}
	
	static void usingToStringTest(){
		List<String> names = Lists.newArrayList("apple","banana","orange","bread",
												"cat","dog","foo","111");
		List<String> lexOrderList  = Ordering.usingToString().sortedCopy(names);
		// same
		System.out.println("lexicographical  order:" + lexOrderList);
		System.out.println("natural order:" +Ordering.natural().sortedCopy(names));
				
	}
	
	static void greatestOfTest(){
		List<Integer> numberList = Lists.newArrayList(2333,411233,4443,413,334,5,3,1,4,5);
		List<Integer> subList = Ordering.natural().greatestOf(numberList, 3);
		System.out.println(subList);
	}
	
	static void itemOrderingTest(){
		List<Item> items = Lists.newArrayList(
				new Item("jack",23),
				new Item("tom", 55),
				new Item("black", 17),
				new Item("tony", 28));
		
		System.out.println("items: "+ items);
		Ordering<Item> nameOrdering = Ordering.natural().nullsFirst().onResultOf(
				new Function<Item, String>() {
					@Override
					public String apply(Item input) {
						return input.getName();
					}
					
		});
		
		Ordering<Item> ageOrdering = Ordering.natural().nullsFirst().onResultOf(
				new Function<Item, Integer>() {

					@Override
					public Integer apply(Item input) {
						return input.getAge();
					}
					
		});
		System.out.println("after name sorted: " + nameOrdering.sortedCopy(items));
		System.out.println("after aget sorted: " + ageOrdering.sortedCopy(items));
		System.out.println("reverse name : " + nameOrdering.reverse().sortedCopy(items));
		
	}
	static void MaxMinTest(){
		Integer  maxNum = Ordering.natural().max(Lists.newArrayList(33,44,1,3,4,2,4));
		System.out.println(maxNum);
		Integer minNum = Ordering.natural().min(3,45,13,4,13,-1);
		System.out.println(minNum);
		String maxString = Ordering.natural().max(Lists.newArrayList("jack","foo","tom","a"));
		System.out.println(maxString);
		String minString = Ordering.natural().min("jack","foo","tom","a","1");
		System.out.println(minString);
		
	}
	
	static void BISearch(){
		List<Integer> orderedList = Ordering.natural().sortedCopy(Lists.newArrayList(1,35,66,7,3));
		System.out.println(orderedList);
		//return the element in the list's index
		int index = Ordering.natural().binarySearch(orderedList, 7);
		System.out.println(index);
		
	}

	public static void main(String[] args) {
		//naturalTest();
		//itemOrderingTest();
		//MaxMinTest();
		//usingToStringTest();
		//greatestOfTest();
		//BISearch();
	}
}
