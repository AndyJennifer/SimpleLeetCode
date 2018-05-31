package simple;

import linkedList.domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2017/12/28 11:24
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */


class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode a = new ListNode(9);


        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(9);
        ListNode b3 = new ListNode(9);
        ListNode b4 = new ListNode(9);
        ListNode b5 = new ListNode(9);
        ListNode b6 = new ListNode(9);
        ListNode b7 = new ListNode(9);
        ListNode b8 = new ListNode(9);
        ListNode b9 = new ListNode(9);
        b.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;
        b7.next = b8;
        b8.next = b9;

        addTwoNumbers(a, b);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, current = head;
        int carry = 0;
        while (p != null || q != null) {
            int a = p != null ? p.val : 0;
            int b = q != null ? q.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;//计算是否进位
            current.next = new ListNode(sum % 10);//创建新节点
            current = current.next;//指向新节点
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {//链表遍历完毕，但是还能进位
            current.next = new ListNode(carry);
        }
        return head.next;
    }


}
