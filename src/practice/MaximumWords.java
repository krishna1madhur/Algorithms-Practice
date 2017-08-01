package practice;
import java.util.*;
import java.util.Map.Entry;
public class MaximumWords {
	public static void main(String[] args) {
		
		String input = "krishna krishna      krishna madhur madhur       ks sd sd sl";
		String[] strings = input.split(" ");
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		
		for(int i=0; i<strings.length; i++) {
			String key = strings[i];
			if(key.isEmpty()) continue;
			if(hMap.containsKey(key)) {
				int count = hMap.get(key);
				hMap.put(key, count+1);
			} else {
				hMap.put(key, 1);
			}
		}
		List<Map.Entry<String, Integer>> hMapList = new ArrayList<Map.Entry<String, Integer>>(hMap.entrySet());

		Collections.sort(hMapList, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}});
		int count = 0;
		Collections.reverse(hMapList);
		for(Map.Entry<String, Integer> key : hMapList) {
			count++;
			System.out.println(key.getKey());
			if(count == 5) break;
		}
	}
}
