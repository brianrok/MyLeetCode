package leetcode;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix = new int[5][];
		matrix[0] = new int[] {1, 4, 7, 11, 15};
		matrix[1] = new int[] {2, 5, 8, 12, 19};
		matrix[2] = new int[] {3, 6, 9, 16, 22};
		matrix[3] = new int[] {10, 13, 14, 17, 24};
		matrix[4] = new int[] {18, 21, 23, 26, 30};
		SearchA2DMatrixII s = new SearchA2DMatrixII();
		System.out.println(s.searchMatrix(matrix, 22));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
        	return false;
        }
        for(int row = 0, col = matrix[0].length - 1; row < matrix.length && col >= 0;) {
        	if (matrix[row][col] == target) {
        		return true;
        	} else if (matrix[row][col] > target) {
        		col--;
        	} else {
        		row++;
        	}
        }
        return false;
    }
	
	public boolean searchMatrix(int[][] matrix, int target, int up, int down, int left, int right) {
		if (up > down || left > right) {
			return false;
		}
		int midHeight = (up + down) / 2;
		int midWidth = (left + right) / 2;
		if (matrix[midHeight][midWidth] == target) {
			return true;
		} else if (matrix[midHeight][midWidth] > target) {
			return searchMatrix(matrix, target, up, midHeight - 1, left, midWidth - 1)
					|| searchMatrix(matrix, target, up, midHeight - 1, midWidth, right)
					|| searchMatrix(matrix, target, midHeight, down, left, midWidth - 1);
		} else {
			return searchMatrix(matrix, target, midHeight + 1, down, midWidth + 1, right)
					|| searchMatrix(matrix, target, midHeight + 1, down, left, midWidth)
					|| searchMatrix(matrix, target, up, midHeight, midWidth + 1, right);
		}
	}
}
