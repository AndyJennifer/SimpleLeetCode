package medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/17 16:21
 * Description:102-二叉树的层序遍历
 * 与二叉树的层序遍历2{@link  LevelOrderBottom}解法类似
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */


public class LevelOrder {

    /**
     * 解法：广度优先
     * 时间复杂度:O(n)遍历整个二叉树
     * 空间复杂度:O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //如果root为null,直接返回
        if (root == null) {
            return res;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {

            //用于保存当层节点所有值的集合
            List<Integer> list = new ArrayList<>();

            //获取当前层级有多少个节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                //添加当层节点的数据
                TreeNode node = queue.poll();
                list.add(node.val);

                //判断当前节点是否存在左右节点，如果有那么存入队列中
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //保存当层节点所有值的集合
            res.add(list);
        }
        return res;
    }
}
