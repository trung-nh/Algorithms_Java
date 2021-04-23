package Problems.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombiSumII {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] candidates = {1, 1, 2, 3, 5};
		List<List<Integer>> res = sol.combinationSum2(candidates, 6);
		System.out.println("res " + res);
	}

}

class Solution {
	List<List<Integer>> combiList = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<Integer> combination = new ArrayList<Integer>();
		int sum = 0;
		Arrays.sort(candidates);
		generateCombinations(candidates, target, combination, sum, 0);
		return combiList;
	}

	private void generateCombinations(int[] candidates, int target, List<Integer> combination, int sum, int startIndex) {
		if (sum == target) {
			List<Integer> validCombination = new ArrayList<Integer>(combination);
			combiList.add(validCombination);
			return;
		}

		if (sum > target) {
			return;
		}

		if (sum < target) {
			for (int i = startIndex; i < candidates.length; i++) {
				if (i > startIndex && candidates[i] == candidates[i - 1]) {
					continue;
				}
				sum = sum + candidates[i];
				combination.add(candidates[i]);
				System.out.println(combination);
				generateCombinations(candidates, target, combination, sum, i + 1);
				sum = sum - candidates[i];
				combination.remove(combination.size() - 1);
			}
		}
	}
}