package medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/22 20:54
 * Description: 107-二叉树的层序遍历2
 * 与二叉树的层序遍历1{@link  medium.tree.LevelOrder}解法类似
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */


public class LevelOrderBottom {


    /**
     * 解法：广度优先
     * 时间复杂度:O(n)遍历整个二叉树
     * 空间复杂度:O(n)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            //这里先获取长度，是因为往集合中添加数据
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
