package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
		Queue<Integer> queue = new ArrayDeque<>();
		queue.size();
	}

	public static int trap(int[] height) {
		int[] maxInLeft = new int[height.length];
		int[] maxInRight = new int[height.length];
		int maxHeight = 0;
		int rain = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
			}
			maxInLeft[i] = maxHeight;
		}
		maxHeight = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
			}
			maxInRight[i] = maxHeight;
		}
		for (int i = 0; i < height.length; i++) {
			if (maxInLeft[i] > height[i] && maxInRight[i] > height[i]) {
				int leftHeight = maxInLeft[i] - height[i];
				int rightHeight = maxInRight[i] - height[i];
				int realHeight = leftHeight > rightHeight ? rightHeight : leftHeight;
				rain += realHeight;
			}
		}
		return rain;
	}
}
