package basic;

import java.util.List;

import com.google.common.base.Function;
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
	public static void main(String[] args) {
		//naturalTest();
		//itemOrderingTest();
	}
}