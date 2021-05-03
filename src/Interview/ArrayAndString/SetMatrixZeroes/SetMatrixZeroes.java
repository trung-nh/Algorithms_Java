package Interview.ArrayAndString.SetMatrixZeroes;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
		sol.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
		}
	}
}

class Solution {
	public void setZeroes(int[][] matrix) {
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		boolean firstColZero = false;
		boolean firstRowZero = false;

		for (int i = 0; i < nrow; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}
		for (int i = 0; i < ncol; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		for (int i = 1; i < nrow; i++) {
			for (int j = 1; j < ncol; j++) {
				// Set the starting cells of corresponding cols and rows to 0
				if (matrix[i][j] == 0) {
					if (i != 0 && j != 0) {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}

		for (int i = 1; i < ncol; i++) {
			// Set the whole col whose starting cell is zero to zero
			if (matrix[0][i] == 0) {
				for (int j = 0; j < nrow; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		for (int i = 1; i < nrow; i++) {
			// Set the whole row whose starting cell is zero to zero
			if (matrix[i][0] == 0) {
				for (int j = 0; j < ncol; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// Handle the cell (0,0)
		if (matrix[0][0] == 0) {
			for (int i = 0; i < nrow; i++) {
				matrix[i][0] = 0;
			}
			for (int i = 0; i < ncol; i++) {
				matrix[0][i] = 0;
			}
			return;
		}
		if (firstRowZero) {
			for (int i = 0; i < ncol; i++) {
				matrix[0][i] = 0;
			}
		}
		if (firstColZero) {
			for (int i = 0; i < nrow; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}