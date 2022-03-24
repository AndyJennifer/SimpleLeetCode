package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2021/5/12 15:51
 * Description:
 * 反转链表前N个节点
 */

public class ReverseListN {

    /**
     * 解法：解决思路和反转整个链表思路差不多{@link ReverseList}
     */

    private static ListNode pre = null;

    public static ListNode reverseListN(ListNode head, int n) {
        if (n == 1) {
            //找到要反转的节点的下一个节点
            pre = head.next;
            return head;
        }
        ListNode node = reverseListN(head.next, n - 1);
        //将当前节点的下一个节点的next节点指向当前节点
        head.next.next = head;
        //将当前节点的下一个节点指向pre;
        head.next = pre;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4});
        ListNode node = reverseListN(head, 3);
        ListNode.printList(node);
    }


}
