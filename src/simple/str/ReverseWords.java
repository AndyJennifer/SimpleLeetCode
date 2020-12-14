package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2020/12/14 16:14
 * Description:反转字符串的单词3
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 该题与{@link medium.str.ReverseWords}解法类似
 * 反转字符串1{@link simple.str.ReverseString}
 * 反转字符串2{@link simple.str.ReverseStr}
 */
public class ReverseWords {

    /**
     * 解法：
     * 思路：开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，
     * 此时找到了一个单词，并能得到单词的起止位置。随后，根据单词的起止位置，
     * 可以将该单词逆序放到新字符串当中。如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public String reverseWordsSolution1(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            //找到单词的最后一位
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            //逆序，从后依次添加单词
            for (int p = start; p < i; p++) {
                //这里的计算公式是i-1为单词最后一位的角标，p++,是为了逆序添加单词
                sb.append(s.charAt(start + i - 1 - p));
            }

            //添加空格
            while (i < length && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    /**
     * 解法：在解法1的思路上，直接原地修改
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public static String reverseWordsSolution2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        while (i < length) {
            //找到了单词的最后一个字符的角标
            int start = i;
            while (i < length && chars[i] != ' ') {
                i++;
            }
            int end = i - 1;
            //交换位置
            swap(chars, start, end);
            //找到下一个单词的开始位置
            while (i < length && chars[i] == ' ') {
                i++;
            }
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }


}
