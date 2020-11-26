package medium.link;

import java.util.ArrayList;
import java.util.List;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/11/25 22:53
 * Description: 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {

    /**
     * 解法1：
     * 这个题和许多回文题都十分类似：
     * 判断是否是回文数：{@link simple.math.IsPalindrome}
     * 最大回文子串:{@link medium.str.LongestPalindrome}
     * 思路：将链表的值复制到数组中，使用双指针判断是否是回文
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public boolean isPalindromeSolution1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int front = 0;
        int back = list.size() - 1;

        //从前后遍历，判断是否相同
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    /**
     * 解法2：使用递归
     * 思路：参考{@link remind.ReversePrintListNode}
     */
    private ListNode temp;

    public boolean isPalindromeSolution2(ListNode head) {
        temp = head;
        return check(head);
    }


    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        //比较第一个数与最后一个数
        boolean result = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return result;
    }

    /**
     * 解法3：
     * 我们可以将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较
     * 思路：
     * 1.找到前半部分链表的尾节点。
     * 2.反转后半部分链表。
     * 3.判断是否回文。
     * 4.恢复链表。
     * 5.返回结果。
     */
    public boolean isPalindromeSolution3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode firstHalfNode = endOfFirstHalf(head);
        ListNode secondHalfNode = reverseList(firstHalfNode.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfNode;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //还原链表
        reverseList(secondHalfNode);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
