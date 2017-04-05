package leetcode.no5longestPalindromicSubstring;

public class Brute {

    public static void main(String[] args) {
        System.out.println(longest("banana"));
        System.out.println(longest("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
        System.out.println(longestAdvanced("bb"));
        System.out.println(longestAdvanced("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
    }

    private static String longest(String input) {
        int longestLength = 0;
        String longestSubString = "";
        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            for (int j = i + longestLength; j <= inputLength; j++) {
                String subString = input.substring(i, j);
                boolean isPalindromic = true;
                for (int start = 0, end = subString.length() - 1; start < end; start++, end--) {
                    if (subString.charAt(start) != subString.charAt(end)) {
                        isPalindromic = false;
                    }
                }
                if (isPalindromic && subString.length() > longestLength) {
                    longestLength = subString.length();
                    longestSubString = subString;
                }
            }
        }

        return longestSubString;
    }

    private static String longestAdvanced(String input) {
        int longestLength = 0;
        String longestPalindromicSubString = "";
        int inputLength = input.length();

        for (int i = 0; i < 2 * inputLength - 1; i++) {
            int left, right;
            if (i % 2 == 0) {
                left = i / 2;
                right = i / 2;
            } else {
                left = i / 2;
                right = i / 2 + 1;
            }
            int borderToLeft = left + 1;
            int borderToRight = inputLength - right;
            int possibleLongest = borderToLeft < borderToRight ? borderToLeft * 2 : borderToRight * 2;
            if (possibleLongest < longestLength) {
                if (borderToLeft <= borderToRight) {
                    continue;
                } else {
                    break;
                }
            }
            while(left >=0 && right < inputLength) {
                if (input.charAt(left) == input.charAt(right)){
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (right - left - 1 > longestLength) {
                longestLength = right - left - 1;
                longestPalindromicSubString = input.substring(left + 1, right);
            }
        }
        return longestPalindromicSubString;
    }
}
