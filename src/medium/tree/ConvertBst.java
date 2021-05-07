package medium.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/26 16:56
 * Description:538-把二叉树搜索树转换为累加树
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点node的新值
 * 等于原树中大于或等于node.val的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ConvertBst {

    private int sum = 0;

    /**
     * 解法：比当前节点的大的节点之和，其实就是该节点右子树之和(使用右根左）
     * BST 相关的问题，要么利用BST左小右大的特性提升算法效率，要么利用中序遍历满足题目的需求
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            //计算所有右子树的和um += root.val;
            sum += root.val;
            root.val = sum;

            convertBST(root.left);
        }
        return root;
    }


}

