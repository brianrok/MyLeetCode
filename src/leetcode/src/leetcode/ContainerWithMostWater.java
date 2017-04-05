package leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int length = height.length;
        int[] indexHeap = new int[length];
        for(int i = 0; i < length; i++) {
            indexHeap[i] = i;
        }
        for (int i = length / 2; i >= 0; i--) {
            
        }
        return 0;
    }
}
