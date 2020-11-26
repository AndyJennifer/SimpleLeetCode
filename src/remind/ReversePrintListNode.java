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
    private void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        printListNode(head);
        System.out.println(head.val);
    }
}
