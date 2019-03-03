package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2019-03-03 17:56
 * Description:
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */

public class reverseString {

    public static void main(String[] args) {


    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            int lastIndex = s.length - 1;
            if (i < lastIndex - i) {
                char temp = s[lastIndex - i];
                s[lastIndex - i] = s[i];
                s[i] = temp;
            }
        }
    }
}
