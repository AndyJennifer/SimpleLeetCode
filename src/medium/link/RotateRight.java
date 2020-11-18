package medium.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/16 22:47
 * Description:旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RotateRight {

    /**
     * 常规思路：
     * 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     * 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     * 断开环 new_tail.next = None，并返回新的链表头 new_head。
     * <p>
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        //找到旧尾节点，并让尾节点指向head，并计算链表的长度
        int n;
        ListNode oldTail = head;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        //找到新的尾节点，新的尾节点的位置为 n-k%n-1
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }

        //新的头节点,为新的尾节点的下一个元素
        ListNode nweHead = newTail.next;

        //断开环
        newTail.next = null;

        return nweHead;
    }
}
