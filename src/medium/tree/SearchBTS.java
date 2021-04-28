package medium.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/28 17:24
 * Description:700-二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */

class SearchBTS {

    /**
     * 解法1：利用二叉搜索树的特性，判断左右，递归
     */
    public TreeNode searchBSTSolution1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBSTSolution1(root.left, val);
        } else {
            return searchBSTSolution1(root.right, val);
        }
    }

    /**
     * 解法2：使用迭代
     */
    public TreeNode searchBSTSolution2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}
