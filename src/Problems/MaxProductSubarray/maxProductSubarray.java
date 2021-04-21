package Problems.MaxProductSubarray;

public class maxProductSubarray {
    public static void main(String[] args) {
        int [] nums = {-2,3,-4,5,-6,0,-7};
        Solution sol = new Solution();
        int res = sol.maxProduct(nums);


    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x == 0) {
                curMax = curMin = 1;
                res = max(res, 0);
                continue;
            }
            int tmp = x * curMax;
            curMax = max(x,max(x * curMin, tmp));
            curMin = min(x,min(tmp, x * curMin));
            res = max(res, curMax);
        }
        return res;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
