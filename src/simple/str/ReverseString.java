package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2019-03-03 17:56
 * Description:翻转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ReverseString {

    /**
     * 解法：双指针
     * 思路：字符串前后对调就行了
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public void reverseStringSolution1(char[] s) {
        for (int i = 0; i < s.length; i++) {
            int lastIndex = s.length - 1;
            if (i < lastIndex - i) {
                char temp = s[lastIndex - i];
                s[lastIndex - i] = s[i];
                s[i] = temp;
            }
        }
    }

    /**
     * 双指针的另一种写法
     */
    public void reverseStringSolution2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
