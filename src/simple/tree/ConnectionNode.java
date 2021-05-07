package simple.tree;


import java.util.Deque;
import java.util.LinkedList;

import domain.Node;

/**
 * Author:  andy.xwt
 * Date:    2021/4/15 22:16
 * Description:116-填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ConnectionNode {

    /**
     * 解法1：广度优先
     */
    public Node solution1(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {

                Node node = deque.poll();

                //最后一个节点不用去连接
                if (i < size - 1)
                    node.next = deque.peek();

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return root;
    }


    public Node solution2(Node root) {
        if (root == null) {
            return null;
        }
        connectionTwoNode(root.left, root.right);
        return root;
    }

    private void connectionTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        //将传入的两个节点连接
        node1.next = node2;

        //连接相同父节点的两个子节点
        connectionTwoNode(node1.left, node1.right);
        connectionTwoNode(node2.left, node2.right);

        //连接跨越父节点的两个子节点
        connectionTwoNode(node1.right, node2.left);

    }


    /**
     * 解法2:深度优先
     */
    public Node solution3(Node root) {
        if (root == null || root.left == null) {
            return null;
        }

        root.left.next = root.right;

        //获取上个节点的next节点，连接跨越父节点的两个子节点
        root.right.next = root.next == null ? null : root.next.left;

        solution3(root.left);
        solution3(root.right);

        return root;
    }

}
