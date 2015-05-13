package basic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class CollectionsExample {
	static final Map<String, String> staticMap = Maps.newHashMap();
	static final List<Integer> staticList = Lists.newArrayList(1, 3, 4, 5, 23,
			3);
	static final Set<Integer> staticSet = Sets.newHashSet(3, 4, 1, 3, 4, 4, 2,
			3);

	// must <=5
	static ImmutableMap<Integer, String> immutableMap = ImmutableMap.of(11,
			"val1", 22, "val2", 3, "val3", 6, "val11", -1, "val345");

	static ImmutableSortedMap<Integer, String> immutableSortedMap = ImmutableSortedMap
			.copyOf(immutableMap);
	// 一键多值
	static ImmutableMultimap<Integer, String> immutableMultimap = ImmutableMultimap
			.of(22, "one val", 11, "two val", 11, "test1", 22, "test2", 1, "1");

	static LinkedListMultimap<Integer, String> linkedListMultimap = LinkedListMultimap
			.create(immutableMultimap);
	static {
		linkedListMultimap.put(11, "test1"); //value里面 可以重复
	}

	static void staticCollectionTest() {
		System.out.println(staticMap);
		System.out.println(staticList);
		System.out.println(staticSet);
	}

	static void immutableCollectionTest() {
		System.out.println(immutableMap);
		System.out.println(immutableSortedMap);
		System.out.println(immutableMultimap);
	}

	static void mutableCollectionTest() {
		System.out.println(linkedListMultimap);
		LinkedHashMultimap<Integer, String> jtestHashMultimap = LinkedHashMultimap
				.create(linkedListMultimap); //会去掉value里面重复的值
		
		System.out.println(jtestHashMultimap);
	}

	public static void main(String[] args) {
		staticCollectionTest();
		immutableCollectionTest();
		mutableCollectionTest();
	}
}
