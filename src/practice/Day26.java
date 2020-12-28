package practice;

import java.util.LinkedList;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/24 11:08
 * Description:
 * 110-平衡二叉树{@link simple.tree.IsBalanced}
 * 111-二叉树的最小深度{@link simple.tree.MinDepth}
 * 112-路径总和{@link simple.tree.HasPathSum}
 */


class Day26 {

    ///////////////////////////////////////////////////////////////////////////
    //平衡二叉树
    ///////////////////////////////////////////////////////////////////////////

    public boolean isBalancedSolution1(TreeNode root) {
        return Math.abs(maxDeep(root.left) - maxDeep(root.right)) <= 1
                && isBalancedSolution2(root.left)
                && isBalancedSolution2(root.right);

    }


    private int maxDeep(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDeep = maxDeep(root.left);
        int rightDeep = maxDeep(root.right);

        return Math.max(leftDeep, rightDeep) + 1;
    }

    public boolean isBalancedSolution2(TreeNode root) {
        return maxDeep2(root) != -1;
    }


    private int maxDeep2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left;
        int right;

        if ((left = maxDeep2(root.left)) == -1
                || (right = maxDeep2(root.right)) == -1
                || Math.abs(left - right) >= 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的最小深度
    ///////////////////////////////////////////////////////////////////////////


    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth1(root.left);
        int right = minDepth2(root.right);

        return (left == 0 || right == 0) ?
                left + right + 1 :
                Math.min(left, right) + 1;
    }


    public int minDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer((node.right));
                }
            }

            res++;
        }

        return res;

    }

    ///////////////////////////////////////////////////////////////////////////
    // 路径总和
    ///////////////////////////////////////////////////////////////////////////

    public boolean hasPathSumSolution1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSumSolution1(root.left, sum - root.val)
                || hasPathSumSolution1(root.right, sum - root.val);
    }

    public boolean hasPathSumSolution2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.offer(root);
        valueQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            int temp = valueQueue.poll();

            if (node.left == null && node.right == null) {
                if (sum == temp) {
                    return true;
                }
                continue;
            }


            if (node.left != null) {
                nodeQueue.offer(node.left);
                valueQueue.offer(temp + node.left.val);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                valueQueue.offer(temp + node.right.val);
            }
        }

        return false;
    }
}
