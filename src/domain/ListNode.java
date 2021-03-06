package domain;

/**
 * Author:  andy.xwt
 * Date:    2018/5/21 11:07
 * Description:
 */

public class ListNode {

    public static final int[] ARRAY_1To5 = new int[]{1, 2, 3, 4, 5};
    public static final int[] ARRAY_6To10 = new int[]{6, 9, 8, 7, 10};

    public int val = -1;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 创建带头结点的链表，并返回该链表的头结点
     *
     * @param array  整形数组
     * @param length 整形数组取值的范围
     * @return 返回当前链表头结点
     */
    public static ListNode createList(int[] array, int length) {
        ListNode header = null;
        ListNode curNode = null;
        for (int i = 0; i < length; i++) {
            if (header == null) {
                header = new ListNode();
                header.val = array[i];
                curNode = header;
            } else {
                ListNode newNode = new ListNode(array[i]);
                curNode.next = newNode;
                curNode = newNode;
            }
        }
        return header;
    }

    public static ListNode createList(int[] array) {
        return createList(array, array.length);
    }

    /**
     * 打印链表中的数据
     */
    public static void printList(ListNode head) {
        if (head != null) {
            ListNode node;
            if (head.val != -1) {
                node = head;
            } else {
                node = head.next;
            }
            while (node != null) {
                if (node.val != -1) {
                    System.out.println(node.val);
                    node = node.next;
                }
            }
        }
    }
}
