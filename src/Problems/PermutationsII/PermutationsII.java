package Problems.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class PermutationsII {
	public static void main(String[] args) {
		int[] nums = {3, 3, 2, 1, 1};
		Solution sol = new Solution();
		sol.permuteUnique(nums);
		System.out.println(sol.permutationList);
	}
}

// Nums might contain duplicate elements
class Solution {
	HashSet<List<Integer>> permutationList = new HashSet<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<Integer> permutation = new ArrayList<Integer>();
		boolean included[] = new boolean[nums.length];
		generatePermutationUnique(nums, permutation, included);
		return new ArrayList<>(permutationList);
	}

	private void generatePermutationUnique(int[] nums, List<Integer> permutation, boolean included[]) {
		if (permutation.size() == nums.length) {
			permutationList.add(new ArrayList<>(permutation));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (included[i]) {
				continue;
			}
			permutation.add(nums[i]);
			included[i] = true;
			generatePermutationUnique(nums, permutation, included);
			permutation.remove(permutation.size() - 1);
			included[i] = false;
		}
	}
}