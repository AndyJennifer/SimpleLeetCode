package practice;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Author:  andy.xwt
 * Date:    2020/12/1 18:00
 * Description:
 * 20-有效的括号{@link simple.str.IsValid}
 * 28-实现strStr(){@link simple.str.StrString}
 * 38-外观数列{@link simple.str.CountAndSay}
 */


class Day17 {

    ///////////////////////////////////////////////////////////////////////////
    // 有效的括号
    ///////////////////////////////////////////////////////////////////////////

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        if (len % 2 == 1) {
            return false;

        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();


    }

    ///////////////////////////////////////////////////////////////////////////
    // 实现strStr()
    ///////////////////////////////////////////////////////////////////////////

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


    public int strStrSolution2(String haystack, String needle) {
        int len = needle.length();
        int n = haystack.length();

        if (needle.length() == 0) {
            return 0;
        }
        int pn = 0;
        while (pn <= n - len) {
            while (pn <= n - len && haystack.charAt(pn) == needle.charAt(0)) {
                pn++;
            }
            int curLen = 0;
            int p1 = 0;

            while (p1 < len && pn < n && haystack.charAt(pn) == needle.charAt(pn)) {
                p1++;
                curLen++;
                pn++;
            }

            if (curLen == len) {
                return pn - len;
            }
            pn = pn - curLen + 1;
        }
        return -1;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 外观数列
    ///////////////////////////////////////////////////////////////////////////
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }
        String previous = countAndSay(n - 1);

        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < previous.length(); i++) {
            if (i < previous.length() - 1 && previous.charAt(i) == previous.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count).append(previous.charAt(i));
                count = 1;
            }
        }
        return sb.toString();

    }
}
