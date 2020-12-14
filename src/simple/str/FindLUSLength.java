package simple.str;

import java.util.HashMap;

/**
 * Author:  andy.xwt
 * Date:    2019-03-05 14:04
 * Description:
 * <p>
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 * <p>
 * 示例 :
 * <p>
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解析: 最长特殊序列可为 "aba" (或 "cdc")
 * 说明:
 * <p>
 * 两个字符串长度均小于100。
 * 字符串中的字符仅含有 'a'~'z'。
 */

public class FindLUSLength {

    /**
     * 解法1：
     * 字符串 x 生成所有字符串的所有子序列共 2^n 个,其中 n 为字符串x的长度
     * 时间复杂度:(n*2^x),其中x为字符串的平均长度,n为字符串的数量
     * 空间复杂度:(n*2^x)
     */
    public int findLUSLengthSolution1(String a, String b) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : new String[]{a, b}) {

            //这里以字符串 abc 为例，其子序列为 "" ，a,b,c, ab,ac,bc,abc 一共8个，
            //也就是说可以用三个bit位，来表示8个状态，如 ab 则为 110，abc 为111
            for (int i = 0; i < (1 << s.length()); i++) {
                String t = "";
                //分别遍历这三个bit位，并对应上相应位置上的字符
                for (int j = 0; j < s.length(); j++) {
                    //判断该bit位上是否为1，如果为1表示该bit位，对应的字符串需要勾选
                    if (((i >> j) & 1) != 0) {
                        t += s.charAt(j);
                    }
                }

                if (map.containsKey(t))
                    map.put(t, map.get(t) + 1);
                else
                    map.put(t, 1);
            }
        }
        int res = -1;
        for (String s : map.keySet()) {
            if (map.get(s) == 1)
                res = Math.max(res, s.length());
        }
        return res;
    }

    /**
     * 解题思路：直接判断长度就行了
     * <p>
     * 时间复杂度：O(min(x,y)，其中x和y是字符串a和b的长度，
     * 空间复杂度：O(1)
     */
    public static int findLUSLengthSolution2(String a, String b) {
        //如果两个字符串相同，那么没有特殊子序列返回-1
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }


}
