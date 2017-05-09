package leetcode.src.leetcode.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintUtils {

    public static void print(int[] nums) {
        List<String> list = Arrays.stream(nums).boxed().map(String::valueOf)
                                 .collect(Collectors.toList());
        String str = String.join(", ", list);
        System.out.println(str);
    }
    
    public static void print(List<?> list) {
    	List<String> strList = list.stream().map(elem -> elem.toString()).collect(Collectors.toList());
        String str = String.join(", ", strList);
        System.out.println(str);
    }
}
