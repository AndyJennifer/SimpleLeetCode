package simple.link;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 22:42
 * Description:反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class ReverseList {


    /**
     * 解题思路：双指针
     * 首先定义一个cur指针，指向头结点，再定义一个pre指针，初始化为null。
     * 然后就要开始反转了，首先要把 cur->next 节点用tmp指针保存一下，也就是保存一下这个节点。
     * 为什么要保存一下这个节点呢，因为接下来要改变 cur->next 的指向了，将cur->next 指向pre ，此时已经反转了第一个节点了。
     * 接下来，就是循环走如下代码逻辑了，继续移动pre和cur指针。
     * 最后，cur 指针已经指向了null，循环结束，链表也反转完毕了。 此时我们return pre指针就可以了，pre指针就指向了新的头结点。
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     */
    public ListNode reverseListSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            //用temp 记录当前节点的下一个节点。
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            //将当前节点，赋值给temp,
            cur = temp;
        }
        return pre;

    }

    /**
     * 解法2：递归
     * 思路：方向思维，如果需要将链表翻转，那么nk+1 的下一个节点应该是nk，递归可以参考{@link remind.ReversePrintListNode}
     * 也就是nk.next.next = nk
     */
    public ListNode reverseListSolution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListSolution2(head.next);
        //nk.next.next =nk
        head.next.next = head;
        //这里注意需要将next置为null
        head.next = null;
        return p;
    }


}
