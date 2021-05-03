package Interview.ArrayAndString.AnagramsGrouping;

import java.util.*;

public class GroupAnagram {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"hey", "hye", "love", "vole", "leov", "alibaba"};
		List<List<String>> res = sol.groupAnagrams(input);
		System.out.println(res);
		Solution_ sol_ = new Solution_();
		List<List<String>> res_ = sol_.groupAnagrams(input);
		System.out.println(res_);
	}
}

// 6ms - 42 MB
class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> myMap = new HashMap<>();
		for (String str : strs) {
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			String key = String.valueOf(charArr);
			if (!myMap.containsKey(key)) {
				myMap.put(key, new ArrayList<>());
			}
			myMap.get(key).add(str);
		}
		return new ArrayList(myMap.values());
	}
}

class Solution_ {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> myMap = new HashMap<>();
		for (String str : strs) {
			int[] counters = new int[26];
			for (int i = 0; i < str.length(); i++) {
				counters[str.charAt(i) - 'a']++;
			}
			String key = "";
			for (int i = 0; i < 26; i++) {
				key += " ";
				key += counters[i];
			}
			if (!myMap.containsKey(key)) {
				myMap.put(key, new ArrayList<>());
			}
			myMap.get(key).add(str);
		}
		return new ArrayList(myMap.values());
	}
}