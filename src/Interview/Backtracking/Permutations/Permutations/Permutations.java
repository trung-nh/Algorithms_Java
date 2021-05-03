package Interview.Backtracking.Permutations.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Solution sol = new Solution();
		sol.permute(nums);
		System.out.println(sol.listOfPermutations);
	}
}

// Backtracking
class Solution {
	List<List<Integer>> listOfPermutations = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		generatePermutations(new ArrayList<Integer>(), nums);
		return listOfPermutations;
	}

	private void generatePermutations(List<Integer> permutation, int[] nums) {
		if (permutation.size() == nums.length) {
			List<Integer> validPermutation = new ArrayList<Integer>(permutation);
			listOfPermutations.add(validPermutation);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (permutation.contains(nums[i])) {
				continue;
			}
			permutation.add(nums[i]);
			generatePermutations(permutation, nums);
			permutation.remove(permutation.size() - 1);
		}
	}
}