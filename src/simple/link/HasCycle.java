package simple.link;

import java.util.HashSet;
import java.util.Set;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/23 11:05
 * Description: 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 *
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class HasCycle {


    /**
     * 解法：通过使用HashSet判断是否存在重复元素就行了，如果成环的话，肯定会重复添加的
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     */
    public boolean hasCycleSolution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 解法：使用快慢指针
     * 思路：如果成环，那么快慢指针肯定会相遇
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public boolean hasCycleSolution2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode low = head;
        ListNode fast = head.next;

        while (low != fast) {

            if (low == null || fast == null) {
                return false;
            }
            low = low.next;//慢指针只用移动一步
            fast = fast.next.next;//快指针，每次都移动两步,这样才会相遇
        }
        return true;
    }

}
