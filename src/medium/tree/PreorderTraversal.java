package medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.Tree;
import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/1/11 17:19
 * Description:二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */


public  class PreorderTraversal {

    /**
     * 思路：前序遍历递归，{@link Tree#preOrder(TreeNode)} }
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public List<Integer> preorderTraversalSolution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }


    /**
     * 解法2：使用栈的方式，模拟递归
     * 思路：前序遍历递归，{@link domain.tree.Tree#preOrder(TreeNode)} }
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public List<Integer> preorderTraversalSolution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }
        return list;
    }

}
