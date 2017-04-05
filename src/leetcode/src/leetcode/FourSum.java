package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.common.QuickSort;

public class FourSum {

    public static void main(String[] args) {
        fourSum(new int[] {1, 0, -1, 0, -2, 2, -2, 2}, 0);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            throw new RuntimeException();
        }
        List<List<Integer>> result = new ArrayList<>();
        QuickSort.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if ((i > 0 && nums[i] == nums[i - 1])
                    || 4 * nums[i] > target || 3 * nums[length - 1] + nums[i] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                result.addAll(threeSum(nums, target, nums[i], j));
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target, int value, int leftBound) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int partialTarget = target - value;
        if (partialTarget < 3 * nums[leftBound] || partialTarget > nums[leftBound] + 2 * nums[length - 1]) {
            return result;
        }
        for (int i = leftBound + 1, j = length - 1; i < j;) {
            int left = nums[i], right = nums[j];
            int sum = left + right + nums[leftBound];
            if (sum == partialTarget) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.add(nums[leftBound]);
                list.add(left);
                list.add(right);
                result.add(list);
                while(i < length && nums[i] == left) {
                    i++;
                }
                while(j > leftBound && nums[j] == right) {
                    j--;
                }
            }
            if (sum < partialTarget) {
                while(i < length && nums[i] == left) {
                    i++;
                }
            }
            if (j > leftBound && sum > partialTarget) {
                while(nums[j] == right) {
                    j--;
                }
            }
        }
        return result;
    }
}
