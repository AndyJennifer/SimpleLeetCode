package medium.link;

import simple.link.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2018/5/21 11:06
 * Description:链表的倒置
 */

public class ReverseLinkedList {

    private static final int ARRAY[] = new int[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        ListNode head = ListNode.createList(ARRAY);
        ListNode reverseHead = reverseList(head);
        ListNode.printList(reverseHead);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode currentNode = head.next;
        while (currentNode != null) {
            //记录下一次将要插入的结点
            ListNode nextNode = currentNode.next;
            //把当前结点插入新链表中
            currentNode.next = newHead.next;
            newHead.next = currentNode;
            //将currentNode指向下一结点
            currentNode = nextNode;
        }
        return newHead;

    }


}
