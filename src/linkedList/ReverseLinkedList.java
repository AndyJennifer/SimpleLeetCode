package linkedList;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2018/5/21 11:06
 * Description:链表的倒置
 */

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(5);
        ListNode b5 = new ListNode(6);
        ListNode b6 = new ListNode(7);
        ListNode b7 = new ListNode(8);
        ListNode b8 = new ListNode(9);
        b.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b7;
        b7.next = b8;
        reverseList(b);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            if (next == null) {
                reverseHead = currentNode;
            }
            currentNode.next = previousNode;//当前节点的next节点为上一个节点。
            previousNode = currentNode;//对上一个节点进行复制
            currentNode = next;//获取下一个元素
        }
        return reverseHead;
    }


}
