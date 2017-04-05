package leetcode;

public class No477TotalHammingDistance {

	public static void main(String[] args) {
		int[] nums = new int[] {4, 14, 2};
		System.out.println(10e9);
		System.out.println(totalHammingDistance(nums));
	}

	public static int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++) {
                bitCount += (nums[i] >> j) & 1;
            }
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
