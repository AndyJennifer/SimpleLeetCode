package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2018/4/28 09:40
 * Description:最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LongestCommonPrefix {


    /**
     * 解法1：
     * 思路：依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，
     * 当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
     * <p>
     * 时间复杂度:O(mn)其中n为最大公共前缀，m为字符串数组长度
     * 空间复杂度:O(1)
     */
    public String longestCommonPrefixSolution1(String[] strs) {

        //先判断字符串数组的长度，如果为空，那么直接返回空字符串
        if (strs == null || strs.length < 1) {
            return "";
        }
        //拿到数组的第一个字符与剩下的字符一一进行比较
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //比较两个字符串，并且获取最长的公共前缀
            prefix = longestCommonPrefix(prefix, strs[i]);
            //如果长度为0，那么就直接返回
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    /**
     * 找到两个字符串最大的公共前缀
     */
    private String longestCommonPrefix(String str1, String str2) {
        //先获取两个字符串中最小的字符串长度
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 解法2：纵向判断，
     * 思路：向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
     * 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     * <p>
     * 空间复杂度：O(nm)其中n为最大公共前缀，m为字符串数组长度
     * 时间复杂度：O(1)
     */
    public String longestCommonPrefixSolution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //如果说等于字符串的长度或发现字符不匹配直接返回
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return str.substring(0, i);
                }
            }
        }
        //当没有提前跳出循环时，那么就返回字符串数组的第一个元素
        return str;
    }

    /**
     * 解法3：二分查找
     * 思路：
     * 显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用 minLength 表示字符串数组中的最短字符串的长度，
     * 则可以在 [0,minLength]的范围内通过二分查找得到最长公共前缀的长度。
     * 每次取查找范围的中间值 mid，判断每个字符串的长度为 mid 的前缀是否相同，
     * 如果相同则最长公共前缀的长度一定大于或等于 mid，如果不相同则最长公共前缀的长度一定小于mid，
     * 通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
     * <p>
     * 时间复杂度:O(mnlogn)
     * 空间复杂度：O(1)
     */
    public String longestCommonPrefixSolution3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        //获取最小的字符串长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0;
        int height = minLength;

        while (low < height) {
            //获取最小字符串的中间位置
            int mid = (height + low) >>> 1;

            if (isCommonPrefix(strs, mid)) {
                //如果包含，那么最长公共前缀，只有可能更大
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }

        return strs[0].substring(0, low);

    }

    private boolean isCommonPrefix(String[] strs, int length) {
        //获取首字符串的子串
        String str0 = strs[0].substring(0, length);
        //拿到子串str0与剩下的字符串比较，判断其他子串是否包含
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
