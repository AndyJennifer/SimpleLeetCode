package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2017/12/28 11:24
 * Description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 */


public class AddTwoNumbers {

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

    /**
     * 思路与解法：
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前
     * 两个链表处相应位置的数字为n1，n2,进位值为carry.则他们的和为 n1+n2+carry,其中 答案链表出相应位置的数字为
     * (n1+n2+carry)%10，而新的进位值为 (n1+n2+carry)/10
     * <p>
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个0
     * <p>
     * 此外，如果链表遍历结束后，有 carry>0，还需要在答案淋巴的后面附加一个节点，节点的值为carry。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {

            //如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个0
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //计算下一位的进位
            carry = sum / 10;

            //移动到下一个位置
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //链表遍历完毕，但是还能进位,则创建新的节点
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


}
