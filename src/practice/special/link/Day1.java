package practice.special.link;


import java.util.Deque;
import java.util.LinkedList;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2021/5/12 2:19 下午
 * Description:
 * 206-反转链表{@link simple.link.ReverseList}
 * 扩展1-反转链表前N个节点{@link simple.link.ReverseListN}
 * 19-删除链表的倒数第N个节点{@link medium.link.RemoveNthFromEnd}
 * 83-删除排序链表中的重复元素{@link simple.link.DeleteDuplicates}
 * 剑指offer18-删除链表中的节点{@link simple.link.DeleteNode}
 * 203-移除链表元素{@link simple.link.RemoveElements}
 * 25-K个一组翻转链表{@link medium.link.ReverseKGroup}
 */

class Day1 {


    ///////////////////////////////////////////////////////////////////////////
    // 翻转链表
    ///////////////////////////////////////////////////////////////////////////
    public ListNode reverseListSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListSolution1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseListSolution2(ListNode head) {
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
    // 反转链表前N个节点
    ///////////////////////////////////////////////////////////////////////////
    private ListNode pre = null;

    public ListNode reverseListN(ListNode head, int n) {
        if (n == 1) {
            pre = head.next;
            return head;
        }
        ListNode node = reverseListN(head.next, n - 1);
        head.next.next = head;
        head.next = pre;
        return node;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 删除链表的倒数第N个节点
    ///////////////////////////////////////////////////////////////////////////
    public ListNode removeNthFromEndSolution1(ListNode head, int n) {
        //计算链表的长度
        ListNode dumpy = new ListNode(-1, head);
        ListNode cur = head;
        int length = calculateLength(head);
        //找到要删除节点的前一位
        for (int i = 1; i < length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dumpy.next;
    }

    public int calculateLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode removeNthFromEndSolution2(ListNode head, int n) {

        ListNode dump = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dump.next;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dump.next;
    }

    public ListNode removeNthFromEndSolution3(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode dumpy = new ListNode(-1, head);
        while (head != null) {
            head = head.next;
            deque.push(head);
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        ListNode node = deque.peek();
        node.next = node.next.next;
        return dumpy.next;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 删除链表中的重复元素
    ///////////////////////////////////////////////////////////////////////////
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 移除链表元素
    ///////////////////////////////////////////////////////////////////////////
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dumpy = new ListNode(-1, head);
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

    ///////////////////////////////////////////////////////////////////////////
    // K个一组翻转链表
    ///////////////////////////////////////////////////////////////////////////

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(k, head);
        ListNode pre = dump;

        while (head != null) {

            //尾节点默认指向头节点
            ListNode tail = pre;

            //判断长度是否大于k
            for (int i = 0; i < k; i++) {
                tail = tail.next;

                //如果长度不够，说明链表长度不满足k个一组，直接返回
                if (tail == null) {
                    return dump.next;
                }
            }

            //记录后面需要连接的节点
            ListNode next = tail.next;

            //翻转满足条件的链表
            ListNode[] reverse = reverse(head, tail);

            //重新设置头尾指向
            head = reverse[0];
            tail = reverse[1];

            //将子链表重新接回原链表
            pre.next = head;
            tail.next = next;

            //重新开始下一次循环
            pre = tail;
            head = tail.next;
        }
        return dump.next;
    }

    /**
     * 反转两个节点之间的链表，并同时返回头尾节点
     */
    private ListNode[] reverse(ListNode head, ListNode tail) {
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
}



