package practice;

import java.util.ArrayList;
import java.util.List;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/25 22:29
 * Description:
 * 206-翻转链表{@link simple.link.ReverseList}
 * 234-回文链表{@link medium.link.IsPalindrome}
 * 234-移除链表元素{@link simple.link.DeleteNode}
 */


class Day15 {

    ///////////////////////////////////////////////////////////////////////////
    // 翻转链表
    ///////////////////////////////////////////////////////////////////////////
    public ListNode reverseListSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public ListNode reverseListSolution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseListSolution1(head.next);
        head.next.next = pre;
        //注意，这里要将next置位null
        head.next = null;
        return pre;

    }

    ///////////////////////////////////////////////////////////////////////////
    // 回文链表
    ///////////////////////////////////////////////////////////////////////////

    public boolean isPalindromeSolution1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    ListNode temp;

    public boolean isPalindromeSolution2(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next) && head.val == temp.val;

        temp = temp.next;
        return res;
    }

    public boolean isPalindromeSolution3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstHalfNode = halfNode(head);
        ListNode secondHalfNode = reverseList(firstHalfNode.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfNode;

        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        reverseList(secondHalfNode);
        return result;

    }

    private ListNode halfNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 移除链表元素
    ///////////////////////////////////////////////////////////////////////////
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
