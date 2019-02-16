package simple;

import linkedList.domain.Node;

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
        Node a = new Node(9);


        Node b = new Node(1);
        Node b1 = new Node(9);
        Node b2 = new Node(9);
        Node b3 = new Node(9);
        Node b4 = new Node(9);
        Node b5 = new Node(9);
        Node b6 = new Node(9);
        Node b7 = new Node(9);
        Node b8 = new Node(9);
        Node b9 = new Node(9);
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

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node head = new Node(0);
        Node p = l1, q = l2, current = head;
        int carry = 0;
        while (p != null || q != null) {
            int a = p != null ? p.val : 0;
            int b = q != null ? q.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;//计算是否进位
            current.next = new Node(sum % 10);//创建新节点
            current = current.next;//指向新节点
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {//链表遍历完毕，但是还能进位
            current.next = new Node(carry);
        }
        return head.next;
    }


}
