package simple.link;

import static simple.link.ListNode.ARRAY_1To5;
import static simple.link.ListNode.ARRAY_6To10;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 20:10
 * Description:合并两个有序数组
 */

public class MergeSortList {


    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(ARRAY_1To5);
        ListNode head2 = ListNode.createList(ARRAY_6To10);
        mergeTwoLists(head1, head2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l2.val > l1.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
