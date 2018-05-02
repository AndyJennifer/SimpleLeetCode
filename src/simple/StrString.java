package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 22:28
 * Description:给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */

public class StrString {

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }

    /**
     * 思路就是先找第一个字符，然后在根据第一个字符，找整个字符串
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        char first = needle.charAt(0);
        int max = haystack.length() - needle.length() >= 0 ? haystack.length() : 0;//最大就是该字符串在最后
        for (int i = 0; i < max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i < max && haystack.charAt(i) != first) ;//遍历找到第一个字符所在的位置
            }
            //找到第一个字符的位置
            if (i < max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                if (end >= max + 1) {
                    return -1;
                }
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); k++, j++)
                    ;//判断后面的字符是否相同
                if (j == end) {//如果最后的位置与结果位置相同，那么就返回
                    return i;
                }

            }
        }
        return -1;
    }
}
