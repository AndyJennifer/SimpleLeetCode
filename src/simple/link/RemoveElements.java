package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/24 18:26
 * Description:移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */


public class RemoveElements {

    /**
     * 解法：定义一个pre指针，指向上一个节点，用另一个指针来遍历
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dumpyHead = new ListNode();
        dumpyHead.next = head;

        ListNode pre = dumpyHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
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
