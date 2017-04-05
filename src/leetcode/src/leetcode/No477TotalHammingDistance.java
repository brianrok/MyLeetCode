package leetcode;

public class No477TotalHammingDistance {

	public static void main(String[] args) {
		int[] nums = new int[] {4, 14, 2};
		System.out.println(10e9);
		System.out.println(totalHammingDistance(nums));
	}

	public static int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) {
            throw new RuntimeException("invalid input");
        }
        int totalDist = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int hamming = nums[i] ^ nums[j];
                int dist = 0;
                for (int pow = 1; pow <= 1e9; pow = pow << 1) {
                    if ((hamming & pow) != 0) {
                        dist++;
                    }
                }
                totalDist += dist;
            }
        }
        return totalDist;
    }
}
