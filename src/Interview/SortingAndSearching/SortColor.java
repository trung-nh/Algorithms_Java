package Interview.SortingAndSearching;

public class SortColor {
	public static void main(String[] args) {

	}
}

// Two-pass
//class Solution_ {
//	public void sortColors(int[] nums) {
//		int z = 0, o = 0, t = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == 0) {
//				z++;
//			} else if (nums[i] == 1) {
//				o++;
//			} else {
//				t++;
//			}
//		}
//		for (int i = 0; i < z; i++) {
//			nums[i] = 0;
//		}
//		for (int i = z; i < z + o; i++) {
//			nums[i] = 1;
//		}
//		for (int i = z + o; i < nums.length; i++) {
//			nums[i] = 2;
//		}
//	}
//}
// One-pass
class Solution {
	public void sortColors(int[] nums) {
		int start = 0, idx = 0, end = nums.length - 1;
		while (start <= end && idx <= end) {
			if (nums[idx] == 0) {
				nums[idx] = nums[start];
				nums[start] = 0;
				start++;
				idx++;
			} else if (nums[idx] == 2) {
				nums[idx] = nums[end];
				nums[end] = 2;
				end--;
			} else {
				idx++;
			}
		}
	}
}