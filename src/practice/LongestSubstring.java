package practice;
import java.util.Scanner;
import java.util.HashMap;
public class LongestSubstring {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		int k = scan.nextInt();
		String result = helper(input, k);
		System.out.println(result);
		scan.close();
	}
	public static String helper(String input, int k) {
		if(input == null || input.length() == 0 || k<=0) return null;
		int startWindow = 0;
		int windowSize = 1;
		HashMap<Character, Integer> hMap = new HashMap<Character,Integer>();
		
		String longestSubstring = input.substring(0,1);
		hMap.put(input.charAt(0), 1);
		
		for(int i=1; i<input.length(); i++) {
			char key = input.charAt(i);
			if(hMap.containsKey(key)) {
				int count = hMap.get(key);
				hMap.put(key, count+1);
			} else {
				hMap.put(key, 1);
				windowSize++;
			}
			System.out.println(hMap);
			while (hMap.size() > k) {
                char charAtstart = input.charAt(startWindow);
                int freq = hMap.get(charAtstart);
                if (freq == 1) {
                	hMap.remove(charAtstart);
                } else {
                	hMap.put(charAtstart, freq - 1);
                }
                startWindow++;
            }
			String temp = input.substring(startWindow,i+1);
			if(temp.length() > longestSubstring.length()) {
				System.out.println(longestSubstring+","+ temp);
				longestSubstring = temp;
			}
		}
		return longestSubstring;
	}
}
