package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2018/5/2 23:27
 * Description:最大字符长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LengthOfLastWord {

    /**
     * 解法1：
     * 思路：将字符串头尾去掉空格，然后split,拿到最后一个就行了
     */
    public int lengthOfLastWordSolution1(String s) {
        //去掉头尾空格，如果为空，则返回为0
        if (s.trim().isEmpty()) {
            return 0;
        }
        //根据空格将字符串进行拆分
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    /**
     * 解法2：
     * 思路：从右向左遍历，从第一个不是空格的字符开始计数，一旦开始计数，再遇到空格就结束了
     */
    public int lengthOfLastWordSolution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i++) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
