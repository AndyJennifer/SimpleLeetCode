package medium.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/26 16:18
 * Description:230-二叉树搜索中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */

class KthSmallest {


    private int res = 0;

    /**
     * 解法:中序遍历二叉树，注意二叉搜索树的特性：中序遍历是升序
     */
    public int kthSmallest(TreeNode root, int k) {
        int num = 0;
        find(root, k, num);
        return res;
    }

    public void find(TreeNode root, int k, int num) {
        if (root == null) {
            return;
        }
        find(root.left, k, num);
        num++;
        if (num == k) {
            res = root.val;
            return;
        }
        find(root, k, num);

    }
}
