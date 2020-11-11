package medium.str;

/**
 * Author:  andy.xwt
 * Date:    2020/10/11 15:58
 * Description:最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */


public class LongestPalindrome {

    /**
     * 暴力解法：枚举所有子串，然后找到最大的回文子串
     * 时间复杂度O(N3)
     * 空间复杂度O(1)，只适用到常数个临时变量
     */
    public static String solution1(String s) {
        //首先判断，字符串的长度是否小于2，那么就直接返回
        if (s == null || s.length() < 1) {
            return "";
        }

        int len = s.length();
        int maxLen = 1;
        //用于记录最长回文子串的初始下标
        int begin = 0;
        char[] charArray = s.toCharArray();

        //枚举所有长度大于1的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    /**
     * 验证子串s[left..right]是否为回文子串
     */
    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩散法：
     * 枚举所有可能的回文子串的中心位置
     * 中心位置可能是一个字符，也有可能是两个相邻的字符
     * 记录最长回文字符串的相关变量
     * <p>
     * 时间复杂度O(N^2)
     * 空间复杂度0(1)
     */
    public static String solution2(String s) {

        //首先判断，字符串的长度是否小于2，那么就直接返回
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        int maxLen = 1;
        //用于记录最长回文子串的初始下标
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);
            int curMax = Math.max(oddLen, evenLen);

            if (curMax > maxLen) {
                maxLen = curMax;
                //找到起始坐标
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    /**
     * 假定 left 为中间位置向两边扩散
     *
     * a        b       b       a
     *         left right
     * a         b           a
     *      left right
     */
    private static int expandAroundCenter(char[] charArray, int left, int right) {
        //当left = right 的时候，回文中心是一个字符，回文串的长度是奇数
        //当right =left +1 的时候，此时回文中心两个字符，回文串的长度是偶数
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        //跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)
        //回文串的长度是 j-i+1-2 = j-i-1
        return j - i - 1;
    }

    /**
     * 动态规划，回文字符串去掉头尾，在该字符串长度大于2的情况下，子串仍然也是回文串
     */
    public static String solution3(String s) {

        //首先判断，字符串的长度是否小于2，那么就直接返回
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        int maxLen = 1;
        //用于记录最长回文子串的初始下标
        int begin = 0;

        //dp[i][j] 表示 s[i...j] 是否是回文串（左闭又闭)
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            //单个字符一定是回文串
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; j++) {
                //字符串头尾不相等，则该字符串不为回文字符串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //如果头尾相等，并且该字符串的长度小于2，该字符串是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {//如果头尾相等，当前字符串是否是回文串，由子串来决定
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //最后找到最长的回文串，及其起始位置就行了
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }

        }
        return s.substring(begin, begin + maxLen);
    }

}
