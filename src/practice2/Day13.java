package practice2;

import java.util.HashSet;
import java.util.Set;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/19 00:09
 * Description:
 * 83-删除排序链表中的重复元素{@link simple.link.DeleteDuplicates}
 * 86-分隔链表{@link medium.link.Partition}
 * 141-环形链表{@link simple.link.HasCycle}
 */


class Day13 {

    ///////////////////////////////////////////////////////////////////////////
    // 删除排序链表中的重复元素
    ///////////////////////////////////////////////////////////////////////////
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 分隔链表
    ///////////////////////////////////////////////////////////////////////////
    public ListNode partition(ListNode head, int x) {

        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);

        ListNode before = before_head;
        ListNode after = after_head;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 环形链表
    ///////////////////////////////////////////////////////////////////////////
    public boolean hasCycleSolution1(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleSolution2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }
}
