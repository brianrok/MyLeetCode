package leetcode;

public class ThirdMax {

	public static void main(String[] args) {
	}
	
	public static int thirdMax(int[] nums) {
        int max, mid, small;
        max = mid = small = Integer.MIN_VALUE;
        int count = 0;
        for (int num: nums) {
            if (num == max || num == mid) {
                continue;
            }
            if (num > max) {
                small = mid;
                mid = max;
                max = num;
                count++;
            } else if (num > mid) {
                small = mid;
                mid = num;
                count++;
            } else if (num >= small) {
                small = num;
                count++;
            }
        }
        
        if (count >= 3) {
            return small;
        }
        return max;
    }

}
