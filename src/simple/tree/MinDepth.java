package simple.tree;

import java.util.LinkedList;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/24 19:23
 * Description: 111-二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */


public class MinDepth {

    /**
     * 解法和{@link  MaxDepth}类似
     */

    /**
     * 解法：深度优先搜索
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = minDepth1(root.left);
        int rightLength = minDepth1(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (leftLength == 0 || rightLength == 0) ?
                leftLength + rightLength + 1
                : Math.min(leftLength, rightLength) + 1;
    }

    /**
     * 解法：广度优先
     * 思路：一层一层遍历，遍历一层开始计数
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int minDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                //找到左右节点都为null的直接返回
                if (node.right == null && node.left == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

}
