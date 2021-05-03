package Interview.Backtracking.WordSearch;

public class WordSearch {
	public static void main(String[] args) {
		char[][] board = {{'a', 'b'}, {'a', 'b'}};
		String word = "aab";
		char[][] board_ = {{'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}};
		String word_ = "aabccd";
		char[][] board__ = {{'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}};
		String word__ = "abcddcbaabcddcbc";
		Solution sol = new Solution();
		System.out.println(sol.exist(board, word)); //true
		System.out.println(sol.exist(board_, word_)); //true
		System.out.println(sol.exist(board__, word__)); //false
	}
}

class Solution {
	public boolean exist(char[][] board, String word) {
		int nrow = board.length;
		int ncol = board[0].length;
		if (word.length() > ncol * ncol) {
			return false;
		}
		for (int i = 0; i < nrow; i++) {
			for (int j = 0; j < ncol; j++) {
				if (word.charAt(0) == board[i][j] && backtrack(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean backtrack(char[][] board, String word, int idx, int i, int j) {
		if (word.length() == idx) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
			return false;
		}
		char tmp = board[i][j];
		board[i][j] = ' ';
		boolean found = backtrack(board, word, idx + 1, i + 1, j)
				|| backtrack(board, word, idx + 1, i - 1, j)
				|| backtrack(board, word, idx + 1, i, j + 1)
				|| backtrack(board, word, idx + 1, i, j - 1);
		board[i][j] = tmp;
		return found;
	}
}