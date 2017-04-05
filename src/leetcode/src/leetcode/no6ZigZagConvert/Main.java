package leetcode.no6ZigZagConvert;

public class Main {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    private static String convert(String s, int numRows) {
        if (numRows <= 0) {
            throw new RuntimeException();
        }
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            buffers[i] = new StringBuffer();
        }
        int currentBuffer = 0;
        boolean forward = true;
        for (int i = 0; i < s.length(); i++) {
            buffers[currentBuffer].append(s.charAt(i));
            if (forward) {
                ++currentBuffer;
            } else {
                --currentBuffer;
            }
            if (currentBuffer >= numRows || currentBuffer < 0) {
                forward = !forward;
                if (currentBuffer >= numRows) {
                    currentBuffer = numRows > 1 ? numRows - 2 : 0 ;
                }
                if (currentBuffer <  0) {
                    currentBuffer = numRows > 1 ? 1 : 0;
                }
            }
        }
        for(int i = 1; i < numRows; i++) {
            buffers[0].append(buffers[i].toString());
        }
        return buffers[0].toString();
    }
}
