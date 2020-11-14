package medium.link;

import java.util.PriorityQueue;

import domain.ListNode;
import domain.Status;

/**
 * Author:  andy.xwt
 * Date:    2020/11/13 16:31
 * Description: 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class MergeKLists {


    /**
     * 解法1：使用了两个有序链表合并法{@link simple.link.MergeTwoLists}
     * 时间复杂度：O((kn+k^2*n)/2) 其中假设链表的长度为n,第一次合并长度为n,第二次为2n....
     * 空间复杂度:O(1)
     */
    public ListNode mergeKListsSolution1(ListNode[] lists) {
        ListNode listNode = null;
        for (int i = 0; i < lists.length; i++) {
            listNode = mergeTwoList(listNode, lists[i]);
        }
        return listNode;
    }

    /**
     * 解法2:分治法
     * 在解法1的基础上进行优化
     * <p>
     * 1.将k个链表配对并将同一对中的链表合并
     * 2.第一轮合并后，k个链表被合成了k/2个链表，平均长度为2n/k,然后是k/4个链表，k/8个链表等等
     * 3.重复这以过程
     * <p>
     * 时间复杂度:O(kn*logk)
     * 空间复杂度:O(logK)
     */
    public ListNode mergeKListsSolution2(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }


    /**
     * 解法3：
     * <p>
     * 我们需要维护当前每个链表没有被合并的元素的最前面一个，K 个链表就最多有
     * k 个满足这样条件的元素，每次在这些元素里面选取 val 属性最小的元素合并到答案中。在选取最小元素的时候，我们可以用优先队列来优化这个过程。
     * <p>
     * 时间复杂度：O(logk*kn) k*n 个节点，logk 为PriorityQueue 折半添加的复杂度
     * 空间复杂度:O(k)
     */
    public ListNode mergeKListsSolution3(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();

        //先将链表数组中所有元素的第一个元素添加进来
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        //重新构造一个新链表
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            //取出下一个元素，添加进来
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }


    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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

        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return head;
    }


}
