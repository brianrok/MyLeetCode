package leetcode.no9PalindromeNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	System.out.println(isPalindrome(121));
        System.out.println(isPalindromeAdvance(121));
    }

    private static boolean isPalindrome(int x) {
        List<Integer> numbers = new ArrayList<>();
        while(x != 0) {
            numbers.add(x % 10);
            x /= 10;
        }
        if (numbers.size() == 0) {
            return true;
        }
        int left = 0, right = numbers.size() - 1;
        while(left < right) {
            if (numbers.get(left) != numbers.get(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private static boolean isPalindromeAdvance(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        if (x < 100 && x % 11 == 0) {
            return true;
        }
        if (x < 1000 && x / 100 == x % 10) {
            return true;
        }
        int v = x % 10;
        x /= 10;
        while(v < x) {
            v = v * 10 + x % 10;
            x /= 10;
        }
        if (v > x) {
            v = v / 10;
        }
        return v == x;
    }
}
