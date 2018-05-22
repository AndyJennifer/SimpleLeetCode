package simple;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 20:10
 * Description:
 */

public class MergeSortList {



    public static void main(String[] args) {
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
//        domain.ListNode b2 = new domain.ListNode(3);
//        domain.ListNode b3 = new domain.ListNode(4);
        b.next = b1;
//        b1.next = b2;
//        b2.next = b3;


        ListNode a = new ListNode(5);
        ListNode a1 = new ListNode(6);
//        domain.ListNode a2 = new domain.ListNode(7);
//        domain.ListNode a3 = new domain.ListNode(8);

        a.next = a1;
//        a1.next = a2;
//        a2.next = a3;

        mergeTwoLists(b, a);
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

    //
}
