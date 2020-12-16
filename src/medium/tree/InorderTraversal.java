package medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/15 10:48
 * Description:二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */


/**
 * 前，中，后序遍历可查看
 * {@link domain.tree.Tree#preOrder(TreeNode)} }
 * {@link domain.tree.Tree#inOrder(TreeNode)}
 * {@link domain.tree.Tree#postOrder(TreeNode)}
 */
public class InorderTraversal {

    /**
     * 解法：递归
     * 思路：递归
     * 时间复杂度:O(n）
     * 空间复杂度:O(n)
     */
    public List<Integer> inorderTraversalSolution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;

    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }

    /**
     * 解法：模拟栈
     * 思路：方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，
     * 区别在于递归的时候隐式地维护了一个栈，
     * 而我们在迭代的时候需要显式地将这个栈模拟出来，其他都相同，具体实现可以看下面的代码。
     * 时间复杂度:O(n）
     * 空间复杂度:O(n)
     */
    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        //栈不为空，表示节点还没遍历完
        while (root != null || !deque.isEmpty()) {

            //一直遍历到最左的节点
            while (root != null) {
                deque.push(root);
                root = root.left;
            }

            //添加节点
            root = deque.pop();
            list.add(root.val);

            //继续遍历该节点的右节点
            root = root.right;
        }
        return list;
    }
}
