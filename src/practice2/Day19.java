package practice2;

import java.util.*;

/**
 * Author:  andy.xwt
 * Date:    2020/12/4 10:02
 * Description:
 * 151-翻转字符串的单词{@link medium.str.ReverseWords}
 * 344-反转字符串{@link simple.str.ReverseString}
 * 387-字符串中的第一个唯一字符{@link simple.str.FirstUniqChar}
 */


class Day19 {

    ///////////////////////////////////////////////////////////////////////////
    // 翻转字符串的单词
    ///////////////////////////////////////////////////////////////////////////
    public String reverseWordsSolution1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join("  ", list);
    }

    public String reverseWordsSolution2(String s) {
        StringBuilder sb = trim(s);
        reverse(sb, 0, sb.length() - 1);
        reverseWords(sb);
        return sb.toString();
    }


    private StringBuilder trim(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        StringBuilder sb = new StringBuilder();
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
        int n = sb.length() - 1;
        int start = 0;
        int end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    public String reverseWordsSolution3(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();

        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                sb.append(ch);
            } else {
                if (sb.length() != 0) {
                    deque.addFirst(sb.toString());
                    sb.setLength(0);
                }
            }
            left++;
        }

        deque.addFirst(sb.toString());

        return String.join(" ", deque);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 翻转字符串
    ///////////////////////////////////////////////////////////////////////////
    public void reverseStringSolution1(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 字符串中的第一个唯一字符
    ///////////////////////////////////////////////////////////////////////////
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
