package leetcode;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new RuntimeException();
        }
        int currentResult = nums[0] + nums[1] + nums[2];
        int minGap = currentResult < target ? target - currentResult : currentResult - target;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int result = nums[i] + nums[j] + nums[k];
                    int gap = result < target ? target - result : result - target;
                    if (gap < minGap) {
                        minGap = gap;
                        currentResult = result;
                    }
                    if (gap == 0) {
                        return result;
                    }
                }
            }
        }
        return currentResult;
    }
}
