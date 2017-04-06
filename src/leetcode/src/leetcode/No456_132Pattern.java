package leetcode;

import java.util.Stack;

public class No456_132Pattern {

	public static void main(String[] args) {

	}
	
	public static boolean find132pattern(int[] nums) {
		Stack<Pair> stack = new Stack<>();
		for(int i: nums) {
			if (stack.isEmpty() || i < stack.peek().min) {
				stack.push(new Pair(i, i));
			} else if (i > stack.peek().min) {
				Pair last = stack.pop();
				if (i < last.max) {
					return true;
				} else {
					last.max = i;
					while(!stack.isEmpty() && i >= stack.peek().max) {
						stack.pop();
					}
					if (!stack.isEmpty() && i > stack.peek().min) {
						return true;
					}
					stack.push(last);
				}
			}
		}
		return false;
	}

}

class Pair {
	int min;
	int max;
	
	public Pair(int min, int max) {
		this.min = min;
		this.max = max;
	}
}
