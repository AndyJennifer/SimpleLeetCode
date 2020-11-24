package medium.link;

import java.util.HashSet;
import java.util.Set;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/24 16:02
 * Description:环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class DetectCycle {

    /**
     * 解法1：
     * 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，
     * 就可以判定链表中存在环。借助哈希表可以很方便地实现
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public ListNode detectCycleSolution1(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;

        }
        return null;
    }

    /**
     * 解法2：
     * 思路：数学推理:https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public ListNode detectCycleSolution2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {

            slow = slow.next;


            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                //如果快指针跑完了，那么就直接返回
                return null;
            }

            //新开一个指针同慢指针一起跑，如果两个指针相遇，那么就返回
            if (slow == fast) {
                ListNode pre = head;
                while (slow != pre) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }

        return null;
    }
}
