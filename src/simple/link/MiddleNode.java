package simple.link;

import java.util.ArrayList;
import java.util.List;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/26 22:19
 * Description:链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 */


public class MiddleNode {

    /**
     * 解法1：
     * 思路：将链表放入集合中，然后返回集合长度的一半就行了
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     */
    public ListNode middleNodeSolution1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        return list.get(list.size() / 2);
    }

    /**
     * 解法1：
     * 思路：统计链表长度n，然后重新遍历链表长度的n/2
     * 时间复杂度：O(n)
     * 空间复杂度:O(1)
     */
    public ListNode middleNodeSolution2(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int k = 0;
        ListNode p = head;
        while (k < n / 2) {
            p = p.next;
            k++;
        }
        return p;
    }

    /**
     * 解法1：
     * 思路：使用快慢指针，快指针走两步，慢指针走一步
     * 时间复杂度：O(n)
     * 空间复杂度:O(1)
     */
    public ListNode middleNodeSolution3(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
