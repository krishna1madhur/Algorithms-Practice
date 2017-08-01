package practice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;

public class CollectionsPractice {
	public static void main(String[] args) {
		Map<String,Integer> hMap = new HashMap<String, Integer>();
		int count = 1;
		List<Integer> values;
		
		hMap.put("KM", 10);
		hMap.put("Spoorthi", 1);
		hMap.put("Krishna", 3);
		hMap.put("Madhuri", 2);
		hMap.put("Naman", 1);
		
//		values = new ArrayList<Integer>(hMap.values());
//		Collections.sort(values);
//		Collections.reverse(values);
//		for(Integer value : values) {
//			if(count==3) break;
//			for(String key : hMap.keySet()){
//				if(hMap.get(key) == value){
//					System.out.println(key + ", " + value);
//					hMap.remove(key);
//					break;
//				}
//			}
//			count++;
//		}
		hMap = sortByValue(hMap);
		System.out.println(hMap);
	}
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }

}
