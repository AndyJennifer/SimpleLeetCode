package simple.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/15 21:46
 * Description:226-翻转二叉树
 * <p>
 * 翻转一棵二叉树。
 */

public class InvertTree {

    /**
     * 解法1：前序遍历
     */
    public TreeNode invertTreeSolution1(TreeNode root) {
        if (root == null) {
            return null;
        }

        //交换root的左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 让左右子节点继续翻转它们的子节点
        invertTreeSolution1(root.left);
        invertTreeSolution1(root.right);

        return root;
    }

    /**
     * 解法2：后序遍历,没有使用中序遍历的原因是，中序遍历的顺序为:左->根->右，如果使用中序，又被替换回来了。
     * 右子树相当于没有被遍历
     */
    public TreeNode inVertTreeSolution2(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 让左右子节点继续翻转它们的子节点
        inVertTreeSolution2(root.left);
        inVertTreeSolution2(root.right);

        //交换root的左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
