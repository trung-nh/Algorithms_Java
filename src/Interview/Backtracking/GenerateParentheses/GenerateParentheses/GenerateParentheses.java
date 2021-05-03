package Interview.Backtracking.GenerateParentheses.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		Solution sol  = new Solution();
		sol.generateParenthesis(3);
		System.out.println(sol.result);
	}
}

class Solution {
	List<String> result = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		backtrack(n, new StringBuilder(), 0, 0);
		return result;
	}

	private void backtrack(int n, StringBuilder combination, int openCount, int closeCount) {
		if (combination.length() == 2 * n) {
			result.add(combination.toString());
			return;
		}
		if (openCount < n) {
			combination.append("(");
			backtrack(n, combination, openCount + 1, closeCount);
			combination.deleteCharAt(combination.length() - 1);
		}
		if (closeCount < openCount) {
			combination.append(")");
			backtrack(n, combination, openCount, closeCount + 1);
			combination.deleteCharAt(combination.length() - 1);
		}
	}
}