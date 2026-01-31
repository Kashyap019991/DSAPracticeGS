package org.kas.demos.Prac.InternalSC;

import java.util.*;

public class ConcurrentModificationExceptionExample {

	public static void main(String args[]) {
		List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				//myList.remove(value);//exception
				it.remove();//no exception
		}
		System.out.println(myList);
		/*Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				// myMap.put("4", "4");
			}
		}*/

		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");//no size changing only updating element so no exception
				// myMap.put("4", "4");
			}
		}

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		for (String key : map.keySet()) {
			if (key.equals("A")) {
//				map.remove(key);
// This will throw ConcurrentModificationException
				//keySet() f a HashMap is a fail-fast iterator Removing an element changes the size of the map,
			}
		}

		Map<String, Integer> map1 = new HashMap<>();
		map1.put("A", 1);
		map1.put("B", 2);
		Iterator<Map.Entry<String, Integer>> iterator = map1.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getKey().equals("A")) {
				iterator.remove(); // Safe removal using iterator's method
			}
		}
	}
}