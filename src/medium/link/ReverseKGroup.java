package medium.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/16 23:12
 * Description:K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当k= 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class ReverseKGroup {

    /**
     * 思路:https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/k-ge-yi-zu-fan-zhuan-lian-biao-by-leetcode-solutio/
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {

            //尾节点默认指向头节点
            ListNode tail = pre;

            //判断剩余部分长度是否大于k
            for (int i = 0; i < k; i++) {
                tail = tail.next;

                //如果长度不够，说明链表长度不满足k个一组，直接返回
                if (tail == null) {
                    return hair.next;
                }
            }

            //记录要连接的节点
            ListNode nex = tail.next;

            //翻转满足条件的链表
            ListNode[] reverse = myReverse(head, tail);

            //重新设置头尾指向
            head = reverse[0];
            tail = reverse[1];

            //将子链表重新接回原链表
            pre.next = head;
            tail.next = nex;

            //重新开始循环
            pre = tail;
            head = tail.next;

        }
        return hair.next;

    }

    /**
     * 反转两个节点之间的链表，并同时返回头尾节点
     * 头节点ListNode[0]
     * 尾节点ListNode[1]
     */
    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;

        while (prev != tail) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return new ListNode[]{tail, head};
    }


}
