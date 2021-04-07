package practice2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/28 11:16
 * Description:
 * <p>
 * 114-二叉树展开为链表{@link medium.tree.Flatten}
 * 144-二叉树的前序遍历{@link medium.tree.PreorderTraversal}
 * 145-二叉树的后序遍历{@link medium.tree.PostorderTraversal}
 */


class Day27 {

    ///////////////////////////////////////////////////////////////////////////
    //二叉树展开为链表
    ///////////////////////////////////////////////////////////////////////////

    public void flattenSolution1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        preorderTraversal(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);

            pre.left = null;
            pre.right = cur;

        }

    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    public void flattenSolution2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }


    public void flattenSolution3(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre != null) {
                    pre = pre.right;
                }

                //左子树的最右节点是右子树的根节点
                pre.right = cur.right;
                //将左子树移动到右边去
                cur.right = next;
                cur.left = null;
            }

            cur = cur.right;
        }

    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的后序遍历
    ///////////////////////////////////////////////////////////////////////////
    public List<Integer> postorderTraversalSolution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }


    private void postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }


    public List<Integer> postorderTraversalSolution2(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();


        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (node.right == null || node.right == pre) {
                list.add(node.val);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }

        }
        return list;
    }
}

