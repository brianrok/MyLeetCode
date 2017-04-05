package leetcode;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		int[][] grid = new int[3][4];
		grid[0] = new int[]{0, 3, 4, 1, 2};
		grid[1] = new int[]{4, 5, 6, 9, 3};
		grid[2] = new int[]{3, 9, 3, 2, 5};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		int[][] MIN = new int[height][width];
		int currentMin = 0;
		for(int i = 0; i < width; i++) {
			currentMin += grid[0][i];
			MIN[0][i] = currentMin;
		}
		currentMin = 0;
		for(int i = 0; i < height; i++) {
			currentMin += grid[i][0];
			MIN[i][0] = currentMin;
		}
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				int candidateUp = MIN[i - 1][j] + grid[i][j];
				int candidateLeft = MIN[i][j - 1] + grid[i][j];
				MIN[i][j] = candidateUp < candidateLeft? candidateUp: candidateLeft;
			}
		}
		return MIN[height - 1][width - 1];
	}
}
