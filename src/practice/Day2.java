package practice;

/**
 * Author:  andy.xwt
 * Date:    2020/10/11 15:45
 * Description:
 * 5-最长回文子串 {@link medium.str.LongestPalindrome}
 * 7-整数翻转 {@link simple.math.ReverserInteger}
 * 9-回文数 {@link simple.math.IsPalindrome}
 */


class Day2 {

    ///////////////////////////////////////////////////////////////////////////
    // 最长回文子串
    ///////////////////////////////////////////////////////////////////////////

    public String longestPalindromeSolution1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int maxLen = 0;
        int begin = 0;
        int len = s.length();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int currentLen = j - i + 1;
                if (currentLen > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = currentLen;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }

    public boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindromeSolution2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int maxLen = 0;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expand(charArray, i, i);
            int evenLen = expand(charArray, i, i + 1);
            int currentMax = Math.max(evenLen, oddLen);

            if (currentMax > maxLen) {
                maxLen = currentMax;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static int expand(char[] charArray, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < charArray.length) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i + 1;
    }

    public String longestPalindromeSolution3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        //定义dp数组
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        //base case 单个字符肯定是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }


        int begin = 0;
        int max = 1;
        char[] array = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //如果头尾不相等，那么一定不是回文串
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else {
                    //如果头尾相等，并且长度为3，那么一定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, max);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 整数翻转
    ///////////////////////////////////////////////////////////////////////////

    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 回文数
    ///////////////////////////////////////////////////////////////////////////

    public boolean isPalindromeSolution1(int x) {

        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == revertNumber || x == revertNumber / 10;

    }

    public boolean isPalindromeSolution2(int x) {
        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length();
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left--;
            right++;
        }
        return true;

    }

}
