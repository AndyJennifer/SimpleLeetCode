package medium.link;

import java.util.Deque;
import java.util.LinkedList;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/13 14:12
 * Description:删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class RemoveNthFromEnd {

    /**
     * 解法1：先获取链表的长度 len，然后遍历到len-n 个节点
     * <p>
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public ListNode removeNthFromEndSolution1(ListNode head, int n) {
        int length = getListNodeLength(head);
        ListNode cur = head;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }
        //这时的cur 为 删除节点的前一个节点
        cur.next = cur.next.next;
        return cur;
    }


    /**
     * 获取链表的长度
     */
    private int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    /**
     * 解法2：使用栈，先将全部的节点压如栈，再依次弹出n个节点，那么栈顶的节点就是需要删除的节点前置节点
     */
    public ListNode removeNthFromEndSolution2(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode dump = new ListNode(-1, head);
        while (head != null) {
            deque.push(head);
            head = head.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        //获取前置节点
        ListNode peek = deque.peek();

        peek.next = peek.next.next;
        return dump.next;
    }

    /**
     * 解法3：快慢指针
     * 先让快指针先跑n个节点，然后慢指针与快指针一起跑。当快指针跑完后，那么慢指针指向的就是倒数的第n个节点
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public ListNode removeNthFromEndSolution3(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return second;
    }
}
