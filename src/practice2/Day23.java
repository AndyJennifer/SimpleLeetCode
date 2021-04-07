package practice2;

import java.util.*;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/15 10:21
 * Description:
 * 94-二叉树的中序遍历{@link medium.tree.InorderTraversal}
 * 100-相同的树{@link simple.tree.IsSameTree}
 * 101-对称二叉树{@link simple.tree.IsSymmetric}
 */


class Day23 {

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的中序遍历
    ///////////////////////////////////////////////////////////////////////////

    public List<Integer> inorderTraversalSolution1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {

            while (root != null) {
                deque.push(root);
                root = root.left;
            }

            TreeNode node = deque.pop();
            list.add(node.val);
            root = node.right;
        }

        return list;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 相同的树
    ///////////////////////////////////////////////////////////////////////////

    public boolean isSameTreeSolution1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTreeSolution1(p.left, q.left) && isSameTreeSolution1(p.right, q.right);
    }

    public boolean isSameTreeSolution2(TreeNode p, TreeNode q) {

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(p);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            TreeNode n1 = q1.poll();
            TreeNode n2 = q1.poll();

            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }


            TreeNode left1 = n1.left;
            TreeNode right1 = n1.right;

            TreeNode left2 = n2.left;
            TreeNode right2 = n2.right;

            if (left1 == null ^ left2 == null) {
                return false;
            }

            if (right1 == null ^ right2 == null) {
                return false;
            }

            q1.offer(n1.left);
            q1.offer(n1.right);


            q2.offer(n2.left);
            q2.offer(n2.right);
        }

        return q1.isEmpty() && q2.isEmpty();
    }

    ///////////////////////////////////////////////////////////////////////////
    // 对称二叉树
    ///////////////////////////////////////////////////////////////////////////
    public boolean isSymmetricSolution1(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetricSolution2(TreeNode root) {


        Queue<TreeNode> q1 = new LinkedList<>();

        q1.offer(root);
        q1.offer(root);

        while (!q1.isEmpty()) {

            TreeNode n1 = q1.poll();
            TreeNode n2 = q1.poll();

            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }

            q1.offer(n1.left);
            q1.offer(n2.right);


            q1.offer(n1.right);
            q1.offer(n2.left);

        }

        return true;

    }


}
