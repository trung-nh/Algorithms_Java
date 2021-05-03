package Problems.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> res = sol.readBinaryWatch(2);
		System.out.println(res);
		System.out.println("Length of res = " + res.size());
	}
}

class Solution {
	final int binTime[] = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

	public List<String> readBinaryWatch(int turnedOn) {
		List<String> res = new ArrayList<>();
		if (turnedOn == 9 || turnedOn == 10) {
			return res;
		}
		backTrack(turnedOn, res, 0, 0, 0);
		return res;
	}

	private void backTrack(int turnedOn, List<String> res, int hour, int min, int idx) {
		if (turnedOn == 0) {
			if (hour <= 11 && min <= 59) {
				StringBuilder myStr = new StringBuilder();
				myStr.append(hour).append(":").append(min < 10 ? "0" + min : min);
				res.add(myStr.toString());
			}
			return;
		}
		for (int i = idx; i < binTime.length; i++) {
			if (isHourIdx(i)) {
				hour += binTime[i];
			} else {
				min += binTime[i];
			}
			backTrack(turnedOn - 1, res, hour, min, i + 1);
			if (isHourIdx(i)) {
				hour -= binTime[i];
			} else {
				min -= binTime[i];
			}
		}
	}

	private boolean isHourIdx(int n) {
		return n >= 0 && n <= 3;
	}
}