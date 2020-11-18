package practice;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/16 15:34
 * Description:
 * 24-两两交换链表中的节点{@link medium.link.SwapPairs}
 * 25-K个一组翻转链表{@link medium.link.ReverseKGroup}
 * 61-旋转链表{@link  medium.link.RotateRight}
 */


class Day12 {

    ///////////////////////////////////////////////////////////////////////////
    // 两两交换链表中的节点
    ///////////////////////////////////////////////////////////////////////////

    public ListNode swapPairsSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsSolution1(newHead.next);
        newHead.next = head;
        return newHead;

    }

    public ListNode swapPairsSolution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode temp = dumpy;

        while (temp.next != null && temp.next.next != null) {
            ListNode listNode1 = temp.next;
            ListNode listNode2 = temp.next.next;
            temp.next = listNode2;
            listNode1.next = listNode2.next;
            listNode2.next = listNode1;
            temp = listNode1;

        }
        return dumpy.next;
    }

    ///////////////////////////////////////////////////////////////////////////
    // K个一组翻转链表
    ///////////////////////////////////////////////////////////////////////////

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;

            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode nex = tail.next;

            ListNode[] reverse = myReverse(head, tail);

            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            tail.next = nex;

            pre = tail;
            head = tail.next;
        }
        return hair.next;

    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return new ListNode[]{tail, head};
    }

    ///////////////////////////////////////////////////////////////////////////
    //旋转链表
    ///////////////////////////////////////////////////////////////////////////

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oldTail = head;

        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        oldTail.next = head;

        //找到新的尾节点，
        ListNode newTail = head;
        for (int i = 0; i < length - k % length - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;
        return newHead;

    }

}
