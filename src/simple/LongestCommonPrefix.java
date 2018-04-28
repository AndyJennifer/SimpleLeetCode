package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/4/28 09:40
 * Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String st[] = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(st));
    }

    /**
     * 分析：获取第一个的字符串，一个一个取判断是否在第二个中，如果不是直接返回""
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
