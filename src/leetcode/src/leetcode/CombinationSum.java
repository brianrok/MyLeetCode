package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.src.leetcode.common.PrintUtils;

public class CombinationSum {

	public static void main(String[] args) {
		List<List<Integer>> result = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		result.forEach(PrintUtils::print);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		Map<Integer, List<List<Integer>>> tmpRes = new HashMap<>();
		for (int i = 1; i <= target; i++) {
			tmpRes.put(i, new ArrayList<>());
		}
		for (int i = 1; i <= target; i++) {
			List<List<Integer>> newList = new ArrayList<>();
			for (int j = 0; j < candidates.length; j++) {
				if (candidates[j] == i) {
					newList.add(Arrays.asList(i));
				} else if (candidates[j] < i) {
					List<List<Integer>> pastRes = tmpRes.get(i - candidates[j]);
					for (List<Integer> resSet : pastRes) {
						if (candidates[j] <= resSet.get(0)) {
							List<Integer> resultList = new ArrayList<>();
							resultList.add(candidates[j]);
							resultList.addAll(resSet);
							newList.add(resultList);
						}
					}
				}
			}
			tmpRes.put(i, newList);
		}
		return tmpRes.get(target);
	}

}
