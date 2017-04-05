package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA");
		System.out.println(result.size());
		int num = 4;
		int t = num & (num - 1);
		System.out.println(t == 0);
	}

	public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry: freq.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
}
