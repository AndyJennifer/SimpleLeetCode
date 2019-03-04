package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2019-03-04 17:50
 * Description:
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */

public class ReverseString2 {
    public static final String text = "Let's take LeetCode contest";

    public static void main(String[] args) {

        reverseString(text);

    }

    public static void reverseString(String s) {
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            char[] chars = str[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int lastIndex = chars.length - 1;
                if (j < lastIndex - j) {
                    char temp = chars[lastIndex - j];
                    chars[lastIndex - j] = chars[j];
                    chars[j] = temp;
                }
            }
            sb.append(chars);
            if(i<str.length-1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
