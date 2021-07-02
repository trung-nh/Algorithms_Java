package Problems.RemoveElement;

public class RemoveElement {

}

class Solution {
	public int removeElement(int[] nums, int val) {
		if(nums.length == 0){
			return  0;
		}
		int count = 0;
		int last = nums.length - 1;
		int start = 0;
		while (last > start) {
			if (nums[last] == val) {
				last--;
				continue;
			}
			if (nums[start] != val) {
				start++;
				count++;
				continue;
			}
			nums[start] = nums[last];
			nums[last] = val;
			start++;
			last--;
			count++;
		}
		if(nums[start]!=val){
			count++;
		}
		return count;
	}
}