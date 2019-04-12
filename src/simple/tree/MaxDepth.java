package simple.tree;

import domain.tree.Tree;
import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2019-04-12 23:06
 * Description:
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 */

public class MaxDepth {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(19);
        tree.insert(30);

        int length = maxDepth(tree.getRoot());
        System.out.println(length);
    }

    /**
     * 解题思路：类似于二叉树的前中序遍历{@link domain.tree.Tree#preOrder(TreeNode)}
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }

}
