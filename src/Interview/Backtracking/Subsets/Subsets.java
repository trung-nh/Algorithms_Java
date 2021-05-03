package Interview.Backtracking.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {0, 1, 2, 3};
		List<List<Integer>> res = sol.subsets(nums);
		System.out.println(res);
	}
}

class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList());
		int len = nums.length;
		List<Integer> subset = new ArrayList<>();
		backtrack(nums, len, 0, subset, res);
		return res;
	}

	private void backtrack(int[] nums, int len, int startIdx, List<Integer> subset, List<List<Integer>> res) {
		for (int i = startIdx; i < len; i++) {
			subset.add(nums[i]);
			res.add(new ArrayList<>(subset));
			backtrack(nums, len, i + 1, subset, res);
			subset.remove(subset.size() - 1);
		}
	}
}