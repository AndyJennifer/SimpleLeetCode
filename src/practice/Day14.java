package practice;

import java.util.HashSet;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/23 14:04
 * Description:
 * 142-环形链表2{@link medium.link.DetectCycle}
 * 160-相交链表{@link simple.link.GetIntersectionNode}
 * 203-移除链表元素{@link simple.link.RemoveElements}
 */


class Day14 {

    ///////////////////////////////////////////////////////////////////////////
    // 环形链表2
    ///////////////////////////////////////////////////////////////////////////
    public ListNode detectCycleSolution1(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycleSolution2(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 相交链表
    ///////////////////////////////////////////////////////////////////////////

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;

    }

    ///////////////////////////////////////////////////////////////////////////
    // 移除链表元素
    ///////////////////////////////////////////////////////////////////////////

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dumpy.next;
    }
}

