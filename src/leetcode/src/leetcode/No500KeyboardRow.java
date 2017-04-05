package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class No500KeyboardRow {
	
	private static final Map<Character, Integer> LETTER_ROW = new HashMap<>();
	
	static {
		LETTER_ROW.put('q', 0);
		LETTER_ROW.put('w', 0);
		LETTER_ROW.put('e', 0);
		LETTER_ROW.put('r', 0);
		LETTER_ROW.put('t', 0);
		LETTER_ROW.put('y', 0);
		LETTER_ROW.put('u', 0);
		LETTER_ROW.put('i', 0);
		LETTER_ROW.put('o', 0);
		LETTER_ROW.put('p', 0);
		LETTER_ROW.put('a', 1);
		LETTER_ROW.put('s', 1);
		LETTER_ROW.put('d', 1);
		LETTER_ROW.put('f', 1);
		LETTER_ROW.put('g', 1);
		LETTER_ROW.put('h', 1);
		LETTER_ROW.put('j', 1);
		LETTER_ROW.put('k', 1);
		LETTER_ROW.put('l', 1);
		LETTER_ROW.put('z', 2);
		LETTER_ROW.put('x', 2);
		LETTER_ROW.put('c', 2);
		LETTER_ROW.put('v', 2);
		LETTER_ROW.put('b', 2);
		LETTER_ROW.put('n', 2);
		LETTER_ROW.put('m', 2);
	}

	public static void main(String[] args) {
		String[] input = new String[] {"Hello", "Alaska", "Dad", "Peace"}; 
		String[] result = findWords2(input);
		for (String word: result) {
			System.out.println(word);
		}
	}

	public static String[] findWords(String[] words) {
		List<String> result = new ArrayList<>();
 		for (String word: words) {
			String lowerWord = word.toLowerCase();
			int row = -1;
			boolean sameRow = true;
			for (int i = 0; i < lowerWord.length(); i++) {
				int lastRow = row;
				row = LETTER_ROW.get(lowerWord.charAt(i));
				if (i != 0 && lastRow != row) {
					sameRow = false;
					break;
				}
			}
			if (sameRow) {
				result.add(word);
			}
		}
 		String[] ret = new String[result.size()];
 		int i = 0;
 		for (String word: result) {
 			ret[i++] = word;
 		}
 		return ret;
    }
	
	public static String[] findWords2(String[] words) {
		return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
	}
}
