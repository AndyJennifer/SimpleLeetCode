package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 20:10
 * Description:合并两个有序数组
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MergeTwoLists {

    /**
     * 解法1：递归算法
     * 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     * 如果两个链表有一个为空，递归结束。
     * 时间复杂度:O(N+M) N 为 l1链表长度 M 为l2链表长度
     * 空间复杂度:O(N+M)
     */
    public ListNode mergeTwoListSolution1(ListNode l1, ListNode l2) {

        //判断有链表是否为空，如果为空，那么就链接另一个
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l2.val > l1.val) {
            l1.next = mergeTwoListSolution1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListSolution1(l1, l2.next);
            return l2;
        }
    }


    /**
     * 解法2，直接比较大小，然后合并
     * 时间复杂度:O(N+M) N 为 l1链表长度 M 为l2链表长度
     * 空间复杂度:O(1)
     */
    public ListNode mergeTwoListSolution2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        //判断有链表是否为空，如果为空，那么就链接另一个
        if (l1 == null) {
            pre.next = l2;
        }
        if (l2 == null) {
            pre.next = l1;
        }
        return head.next;
    }
}
