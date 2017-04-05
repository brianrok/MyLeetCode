package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		Map<Integer, Boolean> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				map.put(nums[i], true);
				if (nums[i] > max) {
					max = nums[i];
				}
			}
		}

		for (int j = 1; j <= max; j++) {
			if (map.get(j) == null) {
				return j;
			}
		}

		return max + 1;
	}

	public int firstMissingPositive2(int[] nums) {
		for (int i = 0; i < nums.length;) {
			if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
				i++;
			} else if (nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[i];
				nums[i] = nums[tmp - 1];
				nums[tmp - 1] = tmp;
			} else {
				i++;
			}
		}
		int j = 0;
		while (j < nums.length && nums[j] == j + 1) {
			j++;
		}
		return j + 1;
	}
}
