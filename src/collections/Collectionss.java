package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collectionss {
	public static void main(String[] args) {
		Set<Integer> test = new HashSet<Integer>();
		Set<Integer> newTest = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(32);
		list.add(4);
		
		list.remove(0);
		System.out.println(list);
		test.add(2);
		test.add(32);
		test.add(4);
		newTest.addAll(test);
		System.out.println(test + " " + newTest);
		Iterator<Integer> it = test.iterator();
		while (it.hasNext()) 
		{ 
			Integer number = it.next(); 
			it.remove(); 
			
		}
		HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
		hMap.put(1,1);
		hMap.put(2,3);
		hMap.put(3,4);
		for(Integer i : hMap.keySet()){
			System.out.println(hMap.get(i));
		}
	}
}