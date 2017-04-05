package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ImplementStackusingQueues {
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
	}
}

class MyStack {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < queue.size(); i++) {
            tmp.add(queue.poll());
        }
        for (int i = 0; i < tmp.size() - 1; i++) {
            queue.add(tmp.get(i));
        }
    }

    // Get the top element.
    public int top() {
        List<Integer> tmp = new ArrayList<Integer>();
        
        for(int i = 0; i < queue.size(); i++) {
            tmp.add(queue.poll());
        }
        int res = tmp.get(tmp.size() - 1);
        for (int i = 0; i < tmp.size(); i++) {
            queue.add(tmp.get(i));
        }
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}