package medium.str;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2018/1/16 22:09
 * Description:无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 */

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(solution1("vjovnhuuxtdalgjccpruzqkysmwrecsalhvaqsvnlynygybinufpnpnfejyinskybgzrywelutkctnkjhryujnbpwbxl"));
    }

    /**
     * 方法1，暴力求解
     * 整个生成子字符串
     * 看它是否不含有重复的字符串，
     * <p>
     * 时间复杂度
     * 1.找到所有子串O(N2）
     * 2.判断子串是否含有唯一字符，Hash Set O(N)
     * 3.整体复杂度O(N3)
     * 空间复杂度
     * HashSet O(M) M为可能出现的所有的字符数
     */
    public static int solution1(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                //判断是否sub中的数据时候重复
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < sub.length(); k++) {
                    char c = sub.charAt(k);
                    if (!set.contains(c)) {
                        set.add(c);
                    } else {
                        break;
                    }
                }
                max = Math.max(max, set.size());
            }
        }
        return max;
    }


    /**
     * 方法2，滑动窗口及优化
     * - 关键字：重复字符--->出现次数
     * 模式识别1：一旦出现次数，需要用到散列表（字符作为键，次数作为值）
     * 构造子串，散列表存效率
     * 模式识别2：涉及到子串，考虑滑动窗口，动态伸缩或扩张
     * aba 移除a 剩下ba 则最大长度为ba 2
     */
    public static int solution2(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int max = 0;
        //哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        while (left < length && right < length) {
            //如果字符没有出现，
            if (!set.contains(s.charAt(right))) {
                //添加当前字符，右指针往又移动一位
                set.add(s.charAt(right++));
                //最大
                max = Math.max(max, right - left);
            } else {
                //如果字符重复，则移除掉第一位，左指针往右移动一位
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }


}
