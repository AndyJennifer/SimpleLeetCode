package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2019-03-03 17:34
 * Description: 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */

public class ToLowerCase {

    /**
     * 解法：
     * 通过 ASCII 码表操作字符串即可。
     * a-z：97-122
     * A-Z：65-90
     * 0-9：48-57
     * <p>
     * 大写字母范围在65~90
     * 小写字母范围在97~122
     * 记住大写在前，小写在后
     */
    public String toLower(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                int b = chars[i] + 32;//这里的32为差值
                chars[i] = (char) b;
            }
        }
        return String.valueOf(chars);
    }

}
