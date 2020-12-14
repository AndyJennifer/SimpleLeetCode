package practice;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/14 16:09
 * Description:
 * 557-反转字符串的单词3{@link simple.str.ReverseWords}
 * 709-转换成小写字母{@link simple.str.ToLowerCase}
 * 剑指offer25-合并两个排序的链表{@link simple.link.MergeTwoLists}
 */


class Day22 {

    ///////////////////////////////////////////////////////////////////////////
    // 反转字符串的单词3
    ///////////////////////////////////////////////////////////////////////////

    public String reverseWordsSolution1(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {

            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }

            for (int j = start; j < i; j++) {
                sb.append(s.charAt(start + i - 1 - j));
            }

            while (i < length && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String reverseWordsSolution2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && chars[i] != ' ') {
                i++;
            }
            int end = i - 1;
            swap(chars, start, end);
            while (i < length && chars[i] == ' ') {
                i++;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 转换成小写字母
    ///////////////////////////////////////////////////////////////////////////
    public String toLower(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'A' && ch <= 'Z') {
                chars[i] = (char) (ch + 32);
            }
        }
        return String.valueOf(chars);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 合并两个排序的链表
    ///////////////////////////////////////////////////////////////////////////
    public ListNode mergeTwoListSolution1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l2.val > l1.val) {
            l1.next = mergeTwoListSolution1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListSolution1(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListSolution2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        if (l1 == null) {
            p.next = l2;
        }

        if (l2 == null) {
            p.next = l1;
        }
        return head.next;
    }
}
