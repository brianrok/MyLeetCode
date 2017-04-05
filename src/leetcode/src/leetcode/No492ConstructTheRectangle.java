package leetcode;

public class No492ConstructTheRectangle {

	public static void main(String[] args) {
		int[] a = constructRectangle(6);
		System.out.println(a[0]);
		System.out.println(a[1]);
	}

	public static int[] constructRectangle(int area) {
		if (area <= 0) {
			throw new RuntimeException("illegal input!");
		}
		int[] result = new int[2];
        int upper = (int) Math.sqrt(area);
        for (int i = upper; i > 0; i--) {
        	if (area % i == 0) {
        		result[0] = area / i;
        		result[1] = i;
        		break;
        	}
        }
        return result;
    }
}
