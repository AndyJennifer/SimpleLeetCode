package medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.Tree;
import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/1/11 17:59
 * Description:145-二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 */


public class PostorderTraversal {


    /**
     * 思路：前序遍历递归，{@link Tree#postOrder(TreeNode)} }
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public List<Integer> postorderTraversalSolution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }


    private void postOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.val);
        }
    }

    /**
     * 解法2：使用栈的方式，模拟递归
     * 思路：前序遍历递归，{@link domain.tree.Tree#postOrder(TreeNode)} }
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public List<Integer> postorderTraversalSolution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        TreeNode pre = null;//用pre记录上一个节点
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            //获取当前根节点
            node = stack.pop();

            //如果node.right==null添加当前节点的左右节点，如果node.right=pre，则添加根节点
            if (node.right == null || node.right == pre) {
                list.add(node.val);
                pre = node;
                node = null;//置为null,方便跳出第二个while循环。
            } else {
                //如果当前节点，还存在右节点，继续把当前节点压栈，遍历其右节点
                stack.push(node);
                node = node.right;
            }
        }
        return list;
    }
}
