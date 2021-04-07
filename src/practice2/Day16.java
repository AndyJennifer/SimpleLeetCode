package practice2;


import java.util.ArrayList;
import java.util.List;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/26 22:11
 * Description:
 * 876-链表的中间节点{@link simple.link.MiddleNode}
 * 10-正则表达式匹配{@link difficult.str.IsMatch}
 * 13-罗马数字转整数{@link simple.str.RomanToInteger}
 * 14-最长公共前缀{@link simple.str.LongestCommonPrefix}
 */


class Day16 {

    ///////////////////////////////////////////////////////////////////////////
    // 链表的中间节点
    ///////////////////////////////////////////////////////////////////////////
    public ListNode middleNodeSolution1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        return list.get(list.size() / 2);
    }

    public ListNode middleNodeSolution2(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int k = 0;
        ListNode p = head;
        while (k < length / 2) {
            p = p.next;
            k++;
        }
        return p;
    }


    public ListNode middleNodeSolution3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 正则表达式匹配
    ///////////////////////////////////////////////////////////////////////////
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 罗马数字转整数
    ///////////////////////////////////////////////////////////////////////////
    public int romanToInt(String s) {
        int sum = 0;
        int preNumber = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (curr > preNumber) {
                sum -= preNumber;
            } else {
                sum += preNumber;
            }
            preNumber = curr;
        }
        sum += preNumber;
        return sum;
    }


    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 最长公共前缀
    ///////////////////////////////////////////////////////////////////////////
    public String longestCommonPrefixSolution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }

        }

        return prefix;

    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;

        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        return str1.substring(0, index);

    }

    public String longestCommonPrefixSolution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str0 = strs[0];
        int len = str0.length();

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || str0.charAt(i) != strs[j].charAt(i)) {
                    return str0.substring(0, i);
                }

            }
        }
        return str0;

    }

    public String longestCommonPrefixSolution3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }

        int low = 0;
        int height = minLength;

        while (low < height) {
            int mid = (low + height) >>> 1;
            if (longestCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }


    private boolean longestCommonPrefix(String strs[], int length) {
        String str0 = strs[0].substring(0, length);
        for (int i = 0; i < str0.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (str0.charAt(i) != strs[j].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
