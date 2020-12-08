package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2020/12/7 10:34
 * Description: 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class CountSegments {

    /**
     * 解法：正则表达式（需要去除前后空白)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int countSegmentsSolution1(String s) {
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        String[] split = s.split("\\s+");
        return split.length;
    }

    /**
     * 解法：若该下标前为空格（或者为初始下标），且自身不为空格，则其为单词开始的下标。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int countSegmentsSolution2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //判断当前字符不是空格 ，及上一个字符必须是空格
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
