package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 22:25
 * Description:剑指offer18-删除链表中的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */

public class DeleteNode {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[]{4, 5, 1, 1, 9});
        ListNode.printList(deleteNode(listNode, 1));

    }

    /**
     * 常见的解题思路：
     * 从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。
     * 因为我们无法访问我们想要删除的节点之前的节点，我们始终不能修改该节点的 next 指针。
     * 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
     * 因为我们知道要删除的节点不是列表的末尾，所以我们可以保证这种方法是可行的。
     */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dumpyHead = new ListNode(-1, head);

        ListNode pre = dumpyHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                //如果值相等，那么就把该节点的上个节点的next指向该节点的next节点
                pre.next = cur.next;
            } else {
                //记录上一个指针
                pre = cur;
            }
            cur = cur.next;

        }
        return dumpyHead.next;
    }

}
