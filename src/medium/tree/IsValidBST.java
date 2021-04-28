package medium.tree;

import java.util.Deque;
import java.util.LinkedList;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/28 17:33
 * Description:98-验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * ][p
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class IsValidBST {


    /**
     * 解法：利用二叉搜索树的特性
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     */
    public boolean isValidBSTSolution1(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.left.val >= max) {
            return false;
        }
        if (root.right.val <= min) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    /**
     * 解法2：利用栈来模拟递归
     */
    public boolean isValidBSTSolution2(TreeNode root) {

        int pre = Integer.MIN_VALUE;

        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //pop是中序遍历
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }

        return true;
    }

}
