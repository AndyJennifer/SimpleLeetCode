package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2020/12/3 18:54
 * Description:验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class IsPalindrome {

    /**
     * 这个题和其他的一些题都差不多
     * 判断是否是回文数：{@link simple.math.IsPalindrome}
     * 最大回文子串:{@link medium.str.LongestPalindrome}
     * 判断回文链表:{@link medium.link.IsPalindrome}
     */


    /**
     * 解法1:筛选加判断
     * 思路：
     * 想将正常的数字及字母添加到集合中，然后翻转对比是否相同
     */
    public boolean isPalindromeSolution1(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            //判断当前字符是字母或者数字
            if (Character.isLetterOrDigit(ch)) {
                //转换成小写，这样大小写的字母也能匹配
                sb.append(Character.toLowerCase(ch));
            }
        }

        StringBuffer sb_reverse = new StringBuffer(sb).reverse();
        return sb_reverse.toString().equals(sb.toString());

    }

    /**
     * 解法：双指针
     * 时间复杂度：O(s.length)
     * 空间复杂度：O(s.length)
     */
    public boolean isPalindromeSolution2(String s) {

        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            //判断当前字符是字母或者数字
            if (Character.isLetterOrDigit(ch)) {
                //转换成小写，这样大小写的字母也能匹配
                sb.append(Character.toLowerCase(ch));
            }
        }

        int n = sb.length();
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 解法3：原来的字符串+双指针
     */
    public boolean isPalindromeSolution3(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            //左指针，如果说该位置不是字母或者数字，那么继续向前移动
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            //右指针，如果说该位置不是字母或者数字，那么继续向后移动
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
