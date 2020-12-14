package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2020/12/14 10:32
 * Description:反转字符串2
 * <p>
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * <p>
 * 提示：
 * <p>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class ReverseStr {


    /**
     * 解法：
     * 思路：我们直接反转每个2k字符块
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(n）
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < s.length(); start += 2 * k) {
            int i = start;
            //反转前k个字符，如果小于k个，则直接反转整个
            int j = Math.min(start + k - 1, s.length());
            while (i < j) {
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        return new String(a);
    }
}
