package leetcode.common;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 44, 15, 32, 4, 76, 31, 29};
        sort(nums);
        PrintUtils.print(nums);
        int[] nums2 = new int[] {100, 0, 97, 98, 99};
        sort2(nums2, 0, nums2.length - 1);
        PrintUtils.print(nums2);
    }

    public static void sort(int[] nums) {
        if (nums == null) {
            return;
        }
        sort2(nums, 0, nums.length - 1);
    }

    @SuppressWarnings("unused")
	private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start + 1;
        int j = end;
        int target = nums[start];

        while(i <= j) {
            if (nums[j] < target && nums[i] > target) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
            if (nums[i] <= target) {
                ++i;
            }
            if (nums[j] >= target) {
                --j;
            }
        }
        nums[start] = nums[j];
        nums[j] = target;
        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    private static void sort2(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start + (end - start) / 2];
        int i = start, j = end;
        while(i <= j) {
            while(nums[i] < pivot) {
                i++;
            }
            while(nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if (j > start) {
            sort2(nums, start, j);
        }
        if (i < end) {
            sort2(nums, i, end);
        }
    }
}
