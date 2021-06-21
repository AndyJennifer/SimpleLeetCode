package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/23 10:36
 * Description:83-删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class DeleteDuplicates {

    /**
     * 思路：当链表中存在相同元素时，让上一个节点指向重复元素的下一个节点就行了。
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
