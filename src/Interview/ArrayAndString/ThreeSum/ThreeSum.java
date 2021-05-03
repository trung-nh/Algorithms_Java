package Interview.ArrayAndString.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		Solution sol = new Solution();
		Solution sol1 = new Solution();
		int[] arr = {-4, -3, -1, 0, 1, 2, 2, 3};
		int[] arr1 = {0, 0, 0};
		sol.threeSum(arr);
		System.out.println(sol.res);
		sol1.threeSum(arr1);
		System.out.println(sol1.res);
	}
}

class Solution {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> threeSum(int[] arr) {
		if (arr.length < 3) {
			return res;
		}
		Arrays.sort(arr);
		helper(arr);
		return res;
	}

	private void helper(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			if (arr[i] + arr[i + 1] + arr[i + 2] > 0) {
				return;
			}
			int j = i + 1;
			int k = arr.length - 1;
			while (j < k) {
				int curSum = arr[i] + arr[j] + arr[k];
				if (curSum == 0) {
					List<Integer> sum = new ArrayList<>();
					sum.add(arr[i]);
					sum.add(arr[j]);
					sum.add(arr[k]);
					res.add(sum);
					// Wrong to use do-while loop while (arr[k] == arr[k +1]) AND  while (arr[j] == arr[j -1])!!!!!
					// i.e.  {-4, 0, 1, 2, 2, 3} => lacking in case (-4,2,2)
					// Correct approach :
					while (j + 1 < arr.length && arr[j] == arr[j + 1]) {
						j++;
					}
					while (k - 1 >= 0 && arr[k] == arr[k - 1]) {
						k--;
					}
					k--;
					j++;

				} else if (curSum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

	}
}