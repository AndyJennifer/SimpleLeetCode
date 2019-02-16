package simple;

import linkedList.domain.Node;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 20:10
 * Description:合并两个有序数组
 */

public class MergeSortList {

    private static final int ARRAY_FIRST[] = new int[]{1, 2, 3, 4, 5};
    private static final int ARRAY_SECOND[] = new int[]{6, 9, 8, 7, 10};


    public static void main(String[] args) {
        Node head1 = Node.createList(ARRAY_FIRST);
        Node head2 = Node.createList(ARRAY_SECOND);
        mergeTwoLists(head1, head2);
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
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
