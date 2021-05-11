package simple.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/24 15:05
 * Description: 110-平衡二叉树
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */


public class IsBalanced {

    /**
     * 解法：自上而下(前序遍历）
     * 这道题中的平衡二叉树的定义是：二叉树的每个节点的左右子树的高度差的绝对值不超过 11，则二叉树是平衡二叉树。
     * 根据定义，一棵二叉树是平衡二叉树，当且仅当其所有子树也都是平衡二叉树，
     * 因此可以使用递归的方式判断二叉树是不是平衡二叉树，递归的顺序可以是自顶向下或者自底向上。
     */
    public boolean isBalancedSolution1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.left)) <= 1
                    && isBalancedSolution1(root.left) && isBalancedSolution1(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 解法:自下而上(后续遍历）
     * 方法一由于是自顶向下递归，因此对于同一个节点，函数 height 会被重复调用，
     * 导致时间复杂度较高。如果使用自底向上的做法，则对于每个节点，函数 height 只会被调用一次。
     * <p>
     * 自下而上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，
     * 再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），
     * 否则返回 -1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
     */
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
                || Math.abs((left - right)) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;

    }
}
