package remind;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/26 18:45
 * Description: 逆序打印链表
 */


public class ReversePrintListNode {

    /**
     * 逆序打印链表
     */
    private static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        printListNode(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        printListNode(n1);
    }
}
