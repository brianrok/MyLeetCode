package leetcode;

import leetcode.common.PrintUtils;

public class SearchForARange {
    private static final int[] NOT_FOUND = new int[] {-1, -1};

    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        int[] range = searchRange(nums, 8);
        PrintUtils.print(range);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return NOT_FOUND;
        }
        int start = 0, end = nums.length - 1, pos = -1, mid;
        int low, high;
        while(start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                pos = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (pos == -1) {
            return NOT_FOUND;
        }
        start = 0;
        end = pos;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        low = start;
        start = pos;
        end = nums.length - 1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        high = end;
        return new int[] {low, high};
    }
}
