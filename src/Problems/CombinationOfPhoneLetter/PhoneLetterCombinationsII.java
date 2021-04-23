package Problems.CombinationOfPhoneLetter;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombinationsII {
	public static void main(String[] args) {
		SolutionII sol = new SolutionII();
		List<String> res = sol.letterCombinations("23");
		System.out.println(res);
	}
}

// Faster
class SolutionII {
	final char[][] myMap = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
			{'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0) {
			return res;
		}
		StringBuilder combi = new StringBuilder();
		generateCombinations(digits, combi, res, 0);
		return res;
	}

	private void generateCombinations(String digits, StringBuilder combi, List<String> res, int idx) {
		if (combi.length() == digits.length()) {
			res.add(new String(combi));
			return;
		}
		char[] values = myMap[digits.charAt(idx) - '2'];
		for (char v : values) {
			combi.append(v);
			generateCombinations(digits, combi, res, idx + 1);
			combi.deleteCharAt(combi.length() - 1);
		}
	}
}