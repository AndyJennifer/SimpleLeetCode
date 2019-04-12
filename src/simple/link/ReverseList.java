package simple.link;

import domain.ListNode;

import static domain.ListNode.ARRAY_1To5;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 22:42
 * Description:
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

    public static void main(String[] args) {
        ListNode head = ListNode.createList(ARRAY_1To5);
        ListNode re = reverseList(head);
        ListNode.printList(re);
    }

    /**
     * 解题思路：迭代的方式
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，
     * 因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     */
    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            //第一步
            ListNode nextTemp = curr.next;
            //第二步
            curr.next = prev;
            //第三步
            prev = curr;
            //第四步
            curr = nextTemp;

            //14步其实是在遍历链表中的节点，并用nextTemp指向当前遍历的节点的下一节点
            //23步就是插入新链表的一个过程。
        }
        return prev;
    }
}
