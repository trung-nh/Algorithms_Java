package Problems.SearchInsertPosition;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 7, 9, 11, 13, 15};
		int target = 4;
		Solution sol = new Solution();
		System.out.println(sol.searchInsert(nums, target));
	}
}

class Solution {
	public int searchInsert(int[] nums, int target) {

		int low = 0, mid = 0, high = nums.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				if (mid == nums.length - 1 || nums[mid + 1] > target) {
					return mid + 1;
				}
				low = mid + 1;
			} else {
				if (mid == 0 || nums[mid - 1] < target) {
					return mid;
				}
				high = mid - 1;
			}
		}
		return -1;
	}
}