package medium.str;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2020/12/4 10:10
 * Description:翻转字符串的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 * <p>
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 * <p>
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class ReverseWords {

    /**
     * 解法：使用原有API
     * 思路：
     * 1.使用 split 将字符串按空格分割成字符串数组；
     * 2.使用 reverse 将字符串数组进行反转；
     * 3.使用 join 方法将字符串数组拼成一个字符串。
     */
    public String reverseWordsSolution1(String s) {
        //除去开头和末尾的空白字符串
        s = s.trim();
        //正则匹配连续的空白字符作为分隔符分割
        String[] split = s.split("\\s+");
        List<String> list = Arrays.asList(split);
        //翻转集合
        Collections.reverse(list);
        //将集合中的数据以一个空格连接起来
        return String.join(" ", list);

    }

    /**
     * 解法：手写API
     * 思路：
     * 1.去掉字符串中前后及中间的多余的空格
     * 2.将修正后的字符串直接全部翻转
     * 3.将单词进行翻转
     */
    public String reverseWordsSolution2(String s) {
        StringBuilder sb = trim(s);
        //翻转字符串
        reverse(sb, 0, sb.length() - 1);
        //翻转每个单词
        reverseWords(sb);
        return sb.toString();
    }


    private StringBuilder trim(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                sb.append(ch);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(ch);
            }
            left++;
        }

        return sb;
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    private void reverseWords(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;

        while (start < n) {

            //开始寻找单词的末尾位置
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);

            start = end + 1;
            end++;

        }
    }

    /**
     * 解法：双端链表
     * 思路：将获取的单词一个一个的添加到链表的头部
     * 时间复杂度：O(n)
     * 控件复杂度：O(n)
     */
    public String reverseWordsSolution3(String s) {
        int left = 0;
        int right = s.length() - 1;

        //去掉头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        //去掉尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        StringBuilder sb = new StringBuilder();
        Deque<String> words = new ArrayDeque<>();
        while (left <= right) {
            char ch = s.charAt(left);
            //如果不为空白字符，那么就添加
            if (ch != ' ') {
                sb.append(ch);
            } else {
                //如果遇到了空白字符，那么将之前的添加到链表的头部中
                if (sb.length() > 0) {
                    words.addFirst(sb.toString());
                    sb.setLength(0);
                }
            }
            left++;
        }

        //添加最后一个单词
        words.addFirst(sb.toString());

        return String.join("  ", words);

    }
}
