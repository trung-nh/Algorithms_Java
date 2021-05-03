package Interview.ArrayAndString.LongestNonRepeatedSubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatedSubstring {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int res = sol.lengthOfLongestSubstring("xasdfghann"); // 7
		System.out.println(res);
	}
}

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		int len = s.length();
		Map<Character, Integer> myMap = new HashMap<>();
		for (int i = 0, j = 0; j < len; j++) {
			if (myMap.containsKey(s.charAt(j))) {
				i = Math.max(i, myMap.get(s.charAt(j)));
			}
			res = Math.max(res, j - i + 1);
			myMap.put(s.charAt(j), j + 1);
		}

		return res;
	}
}