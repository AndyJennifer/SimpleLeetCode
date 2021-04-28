package simple.tree;

import java.util.Deque;
import java.util.LinkedList;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2019-04-12 23:06
 * Description:二叉树的最大深度
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


    /**
     * 树的遍历方式总体分为两类：
     * 深度优先搜索（Depth-First-search 简称DFS）、
     * 广度优先搜索（Breadth-First-Search 简称BFS)）
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历
     * 常见的 BFS ： 层序遍历（即按层遍历）
     */

    /**
     * 解法：深度优先搜索
     * 思路：类似于二叉树的前中序遍历{@link domain.tree.Tree#preOrder(TreeNode)}
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int maxDepthSolution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepthSolution1(root.left);
        int rightLength = maxDepthSolution1(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }


    /**
     * 解法：广度优先
     * 思路：一层一层遍历，遍历一层开始计数
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int maxDepthSolution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                //一层一层的遍历
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
