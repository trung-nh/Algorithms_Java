package Problems.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args) {
		Solution sol1 = new Solution();
		sol1.combine(4,2);
		System.out.println(sol1.combinationList);
		Solution sol2 = new Solution();
		sol2.combine(6,5);
		System.out.println(sol2.combinationList);
	}
}

class Solution {
	List<List<Integer>> combinationList = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		List<Integer> combi = new ArrayList<>();
		generateCombinations(n, k, combi, 1);
		return combinationList;
	}

	private void generateCombinations(int n, int k, List<Integer> combi, int startNum) {
		if (combi.size() == k) {
			combinationList.add(new ArrayList<>(combi));
			return;
		}
		for (int i = startNum; i <= n; i++) {
			combi.add(i);
			generateCombinations(n, k, combi, i+1);
			combi.remove(combi.size()-1);
		}
	}
}