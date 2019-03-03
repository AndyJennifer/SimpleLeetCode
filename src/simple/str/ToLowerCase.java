package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2019-03-03 17:34
 * Description:
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */

public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLower("FUCK"));
    }

    public static String toLower(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                int b = chars[i] + 32;
                chars[i] = (char) b;
            }
        }
        return String.valueOf(chars);
    }

}
