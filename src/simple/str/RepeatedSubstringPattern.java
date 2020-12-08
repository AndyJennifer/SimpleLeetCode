package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2020/12/7 13:40
 * Description:重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class RepeatedSubstringPattern {

    /**
     * 解法：如果一个长度为n的字符串s，可以由它的一个长度为n'的子串s'重复多次构成那么：
     * 1.n一定是n'的倍数：
     * 2.s'一定是s的前缀
     * 3.对于任意的i [n',n) 有 s[i] =s[i-n']
     * 优化：因为子串至少需要重复一次，所以n'不会大于n的一半
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     */
    public boolean repeatedSubstringPatternSolution1(String s) {
        //因为子串至少需要重复一次，所以n'不会大于n的一半
        int n = s.length();
        //这里i不从0开始，是因为要考虑0作为分母的情况，n%i
        for (int i = 1; i * 2 <= n; i++) {
            //这里的i为 n'子串的长度
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    //对于任意的i [n',n) 有 s[i] =s[i-n']
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法：
     * 思路：
     * 我们将两个 s 连在一起，并移除第一个和最后一个字符。如果 s 是该字符串的子串,则满足要求
     * <p>
     * 如 s 为 abcabc 那么s+s 为 abcabc abcabc，移除a ,为 bcabc abcabc
     */
    public boolean repeatedSubstringPatternSolution2(String s) {
        //从位置 1 开始查询，并希望查询结果不为位置 n
        return (s + s).indexOf(s, 1) != s.length();
    }

}
