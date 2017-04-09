package leetcode;

public class No239SlidingWindowMax {

	public static void main(String[] args) {

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int[] leftSlideMax = new int[nums.length];
        int[] rightSlideMax = new int[nums.length];
        leftSlideMax[0] = nums[0];
        rightSlideMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            leftSlideMax[i] = (i % k == 0) ? nums[i]: Math.max(leftSlideMax[i - 1], nums[i]);
            int j = nums.length - i - 1;
            rightSlideMax[j] = (j % k == 0) ? nums[j]: Math.max(rightSlideMax[j + 1], nums[j]);
        }
        for (int i = 0, j = 0; i + k <= nums.length; i++) {
            result[j++] = Math.max(rightSlideMax[i], leftSlideMax[i + k - 1]);
        }
        return result;
    }
}
