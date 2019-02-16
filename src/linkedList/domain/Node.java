package linkedList.domain;

/**
 * Author:  andy.xwt
 * Date:    2018/5/21 11:07
 * Description:
 */

public class Node {

    public int val = -1;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    /**
     * 创建带头结点的链表，并返回该链表的头结点
     *
     * @param array  整形数组
     * @param length 整形数组取值的范围
     * @return 返回当前链表头结点
     */
    public static Node createList(int array[], int length) {
        Node header = new Node();
        Node curNode = null;
        for (int i = 0; i < length; i++) {
            Node currentNode = new Node();
            currentNode.val = array[i];
            if (header.next == null) {
                header.next = currentNode;
                curNode = currentNode;
            } else {
                curNode.next = currentNode;
                curNode = currentNode;
            }
        }
        return header;
    }

    public static Node createList(int array[]) {
        return createList(array, array.length);
    }

    /**
     * 打印链表中的数据
     */
    public static void printList(Node head) {
        if (head != null) {
            Node node = head.next;
            while (node != null) {
                if (node.val != -1) {
                    System.out.println(node.val);
                    node = node.next;
                }
            }
        }
    }
}
