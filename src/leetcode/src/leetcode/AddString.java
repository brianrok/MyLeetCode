package leetcode;

public class AddString {
	
	public static void main(String[] args) {
		AddString as = new AddString();
		System.out.println(as.addStrings("123", "123"));
		int a = 1 & 2;
		System.out.print(a);
	}
	
	public String addStrings(String num1, String num2) {
        int maxResultLength = num1.length() > num2.length()? num1.length() + 1: num2.length() + 1;
        char[] chars = new char[maxResultLength];
        for (int i = 0; i < maxResultLength; i++) {
            chars[i] = '0';
        }
        int take = 0, left = num1.length() - 1, right = num2.length() - 1;
        int charsIndex = maxResultLength - 1;
        char ZERO = '0';
        while(left >= 0 || right >= 0) {
            char cLeft = left >= 0? num1.charAt(left): ZERO;
            char cRight = right >= 0? num2.charAt(right): ZERO;
            int numLeft = cLeft - ZERO;
            int numRight = cRight - ZERO;
            int tmpResult = numLeft + numRight + take;
            chars[charsIndex--] = (char)(tmpResult % 10 + ZERO);
            take = tmpResult / 10;
            left--; right--;
        }
        if (take > 0) {
            chars[0] = (char)(take + ZERO);
        }
        StringBuilder builder = new StringBuilder();
        if (chars[0] != ZERO) {
            builder.append(chars[0]);
        }
        for (int i = 1; i < maxResultLength; i++) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
