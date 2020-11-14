package practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import domain.ListNode;
import domain.Status;

/**
 * Author:  andy.xwt
 * Date:    2020/11/13 14:00
 * Description:
 * 19-删除链表的倒数第N个节点{@link medium.link.RemoveNthFromEnd}
 * 21-合并两个有序链表{@link simple.link.MergeTwoLists}
 * 23-合并K个升序链表{@link medium.link.MergeKLists}
 */


class Day11 {

    ///////////////////////////////////////////////////////////////////////////
    // 删除链表的倒数第N个节点
    ///////////////////////////////////////////////////////////////////////////

    public ListNode removeNthFromEndSolution1(ListNode head, int n) {

        int length = getLength(head);
        ListNode cur = head;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return cur;


    }

    private int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            listNode = listNode.next;
            length++;

        }
        return length;
    }

    public ListNode removeNthFromEndSolution2(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return second;
    }

    public ListNode removeNthFromEndSolution3(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;

        while (head != null) {
            deque.push(head);
            head = head.next;
        }

        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        ListNode peek = deque.peek();
        peek.next = peek.next.next;

        return cur;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 合并两个有序链表
    ///////////////////////////////////////////////////////////////////////////

    public ListNode mergeTwoListSolution1(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l2.val > l1.val) {
            l1.next = mergeTwoListSolution2(l1, l2.next);
            return l1;
        } else {
            l2.next = mergeTwoListSolution2(l1.next, l2);
            return l2;
        }

    }

    public ListNode mergeTwoListSolution2(ListNode l1, ListNode l2) {


        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l1 = l1.next;
            } else {
                head.next = l1;
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }

        return cur.next;

    }
    ///////////////////////////////////////////////////////////////////////////
    // 合并K个升序链表
    ///////////////////////////////////////////////////////////////////////////

    public ListNode mergeKListsSolution1(ListNode[] lists) {
        ListNode cur = null;
        for (int i = 0; i < lists.length; i++) {
            cur = mergeTwoLists(cur, lists[i]);
        }
        return cur;
    }

    public ListNode mergeKListsSolution2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);

    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeKListsSolution3(ListNode[] lists) {
        PriorityQueue<Status> priorityQueue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            priorityQueue.offer(new Status(listNode.val, listNode));
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (!priorityQueue.isEmpty()) {
            Status s = priorityQueue.poll();
            cur.next = s.ptr;
            cur = cur.next;
            if (s.ptr.next != null) {
                priorityQueue.offer(new Status(s.ptr.next.val, s.ptr.next));
            }
        }

        return head.next;

    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                l1 = l1.next;
                cur.next = l1;
            } else {
                l2 = l2.next;
                cur.next = l2;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return head.next;
    }

}
