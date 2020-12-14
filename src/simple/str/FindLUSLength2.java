package simple.str;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Author:  andy.xwt
 * Date:    2020/12/10 22:57
 * Description:最长特殊序列 II
 * <p>
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: "aba", "cdc", "eae"
 * 输出: 3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有给定的字符串长度不会超过 10 。
 * 给定字符串列表的长度将在 [2, 50 ] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class FindLUSLength2 {

    /**
     * 解法同{@link FindLUSLength}
     * 时间复杂度:(n*2^x),其中x为字符串的平均长度,n为字符串的数量
     * 空间复杂度:(n*2^x)
     */
    public int findLUSlengthSolution1(String[] strs) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            for (int i = 0; i < (1 << str.length()); i++) {
                StringBuilder s = new StringBuilder();

                for (int j = 0; j < str.length(); j++) {
                    if (((i >> j) & 1) != 0) {
                        s.append(s.charAt(j));
                    }
                }
                map.put(s.toString(), map.getOrDefault(s, 0) + 1);
            }
        }

        int max = -1;
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                max = Math.max(max, s.length());
            }
        }
        return max;
    }

    /**
     * 解法：依次判断是否是字符串中其他子串
     * 思路：如果存在这样的特殊序列，那么它一定是某个给定的字符串。
     * 检查每个字符串是否是其他字符串的子序列。如果不是，则它是一个特殊序列。最后返回长度最大的特殊序列。如果不存在特殊序列，返回 -1。
     * 时间复杂度:(n*2^x),其中x为字符串的平均长度,n为字符串的数量
     * 空间复杂度:(1)
     */
    public int findLUSlengthSolution2(String[] strs) {

        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs.length; j++) {
                //排除自己与自己比较
                if (i == j) {
                    continue;
                }
                //如果字符串是其他字符串的子串，那么就直接跳过
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }

            //只有字符串不是所有的字符串的子串，那么就统计长度
            if (j == strs.length) {
                max = Math.max(max, strs[i].length());
            }
        }

        return max;

    }

    /**
     * 判断字符串a 是否是字符串 b的子串
     */
    private boolean isSubsequence(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length() && j < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                j++;
            }
        }
        return j == a.length();
    }


    /**
     * 方法二 中需要判断每个字符串是否为特殊序列。如果最开始可以先将所有字符串排序，则可以节省一部分计算。
     * <p>
     * 时间复杂度:(n*2^x),其中x为字符串的平均长度,n为字符串的数量
     * 空间复杂度:(1)
     */
    public int findLUSlengthSolution3(String[] strs) {

        //按照降序排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                //排除自己与自己比较
                if (i == j) {
                    continue;
                }
                //如果字符串是其他字符串的子串，那么就直接跳过
                if (isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }

            //因为已经排序了，所以直接拿对应角标的字符串长度,和方法2比较，这里少了比较的过程。
            if (flag) {
                return strs[i].length();
            }
        }

        return -1;

    }
}

