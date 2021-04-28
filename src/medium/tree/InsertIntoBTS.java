package medium.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/28 22:48
 * Description: 701-二叉搜索中的插入操作
 * <p>
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class InsertIntoBTS {


    /**
     * 解法：递归
     */
    public TreeNode insertIntoBSTSolution1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBSTSolution1(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBSTSolution1(root.right, val);
        }
        return root;

    }

    /**
     * 解法：迭代
     */
    public TreeNode insertIntoBSTSolution2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        //用一个变量保存对root节点的引用

        TreeNode post = root;
        while (post != null) {

            //如果节点比当前值大，则找左子树
            if (post.val > val) {
                if (post.left == null) {
                    post.left = new TreeNode(val);
                    break;
                } else {
                    post = post.left;
                }
            } else {
                //如果节点比当前值小，则找右子树
                if (post.right == null) {
                    post.right = new TreeNode(val);
                    break;
                } else {
                    post = post.right;
                }
            }
        }
        return root;
    }
}
