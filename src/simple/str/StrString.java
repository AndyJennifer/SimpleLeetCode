package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 22:28
 * Description:实现strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
 * 。如果不存在，则返回  -1。
 */

public class StrString {

    /**
     * 解法1：滑动窗口，窗口长度为needle长度
     * 时间复杂度：O((N-L)L) 其中 N 为 haystack 的长度，L 为needle的长度，内层循环中字符串的复杂度为L，共需要比较N-L次
     * 空间复杂度：O(1)
     */
    public int strStrSolution1(String haystack, String needle) {
        int len = needle.length();
        int n = haystack.length();

        for (int start = 0; start <= n - len; start++) {
            if (haystack.substring(start, start + len).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 解法2：双指针
     * 思路：上一个方法的缺陷是会将 haystack 所有长度为 L 的子串都与 needle 字符串比较，实际上是不需要这么做的。
     * 首先，只有子串的第一个字符跟 needle 字符串第一个字符相同的时候才需要比较。
     * 就是先找第一个字符，然后在根据第一个字符，找整个字符串
     *
     * 时间复杂度:O((N-L)L) 最优O(L)
     * 空间复杂度:O(1）
     */
    public int strStrSolution2(String haystack, String needle) {
        int len = needle.length();
        int n = haystack.length();
        if (len == 0) {
            return 0;
        }

        int pn = 0;

        while (pn <= n - len) {
            //从haystack 中找到与 needle 相同的第一个字符的位置
            while (pn <= n - len && haystack.charAt(pn) != needle.charAt(0)) {
                pn++;
            }

            //比较从开始位置pn能匹配needle字符串的最大长度
            int currLen = 0, pl = 0;
            while (pl < len && pn < n && haystack.charAt(pn) == needle.charAt(pn)) {
                pn++;
                pl++;
                currLen++;
            }
            //如果最大的长度等于需要匹配的needle的长度，那么就返回开始位置
            if (currLen == len) {
                //开始的位置 = pn-len,因为pn已经移动了
                return pn - len;
            }
            //如果不满足，那么就需要将pn移动到最初找到的第一个字符的下一个位置
            pn = pn - currLen + 1;
        }

        return -1;
    }
}
