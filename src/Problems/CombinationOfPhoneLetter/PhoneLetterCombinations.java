package Problems.CombinationOfPhoneLetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneLetterCombinations {
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> res = sol.letterCombinations("238");
		System.out.println(res);
	}
}

class Solution {
	HashMap<Integer, List<Character>> myMap = new HashMap<>();

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0) {
			return res;
		}
		initMyMap();
		StringBuilder combi = new StringBuilder();
		generateCombinations(digits, combi, res, 0);
		return res;
	}

	private void generateCombinations(String digits, StringBuilder combi, List<String> res, int startIdx) {
		if (combi.length() == digits.length()) {
			res.add(new String(combi));
			return;
		}
		for (char c : myMap.get(Character.getNumericValue(digits.charAt(startIdx)))) {
			combi.append(c);
			generateCombinations(digits, combi, res, startIdx + 1);
			combi.deleteCharAt(combi.length() - 1);
		}
	}

	private void initMyMap() {
		List<Character> chars = new ArrayList<>();
		int id = 0;
		for (int i = 97; i < 123; i++) {
			chars.add((char) i);
		}
		for (int i = 2; i < 10; i++) {
			List<Character> values = new ArrayList<>();
			values.add(chars.get(id++));
			values.add(chars.get(id++));
			values.add(chars.get(id++));
			myMap.put(i, values);
			if (i == 7 || i == 9) {
				values.add(chars.get(id++));
			}
		}
	}

}