package medium.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/16 15:39
 * Description: 两两交换链表的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 */


public class SwapPairs {

    /**
     * 解法1：递归
     * 思路：如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，
     * 原始链表的第二个节点变成新的链表的头节点。链表中的其余节点的两两交换可以递归地实现。
     * 在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
     * <p>
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */
    public ListNode swapPairsSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsSolution1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 解法2：迭代法
     * 思路：两两交换
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public ListNode swapPairsSolution2(ListNode head) {
        ListNode dumpyHead = new ListNode(0);
        dumpyHead.next = head;
        ListNode temp = dumpyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode listNode1 = temp.next;
            ListNode listNode2 = temp.next.next;
            temp.next = listNode2;
            listNode1.next = listNode2.next;
            listNode2.next = listNode1;
            temp = listNode1;
        }
        return dumpyHead.next;
    }


}
