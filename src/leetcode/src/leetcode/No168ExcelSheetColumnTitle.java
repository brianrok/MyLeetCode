package leetcode;

public class No168ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(0));
	}

	public static String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
