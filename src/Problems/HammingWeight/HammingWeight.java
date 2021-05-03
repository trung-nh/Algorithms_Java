package Problems.HammingWeight;

public class HammingWeight {
	public static void main(String[] args) {
		Solution sol= new Solution();
		int res = sol.hammingWeight(0b11111111111111111111111111111101);
		System.out.println(res);
	}
}

class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int bits = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				bits++;
			}
			mask <<= 1;
		}
		return bits;
	}

	// Faster solution
	// Bitwise AND : n AND (n - 1)
	// i.e.  n  = ...100
	//      n-1 = ...011
	// AND =>     ...000 and we get the no.of ONES up to the least significant 1-bit of n (which is 1)
	public int hammingWeight_(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}
}