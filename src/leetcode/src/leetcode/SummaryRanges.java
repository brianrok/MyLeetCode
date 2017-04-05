package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int[] array = new int[] {0, 1, 2, 4, 5, 7};
		List<String> result = summaryRanges(array);
		for(String row: result) {
			System.out.println(row);
		}
	}

	public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
        	return result;
        }
        int start = 0, end = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
        	if (nums[i] == nums[end] + 1) {
        		end = i;
        	} else {
        		result.add(record(nums[start], nums[end]));
        		start = end = i;
        	}
        }
        result.add(record(nums[start], nums[end]));
        return result;
    }
	
	public static String record(int start, int end) {
		if (start == end) {
			return start + "";
		} else {
			return start + "->" + end;
		}
	}
}
