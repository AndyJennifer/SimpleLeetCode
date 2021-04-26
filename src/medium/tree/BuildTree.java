package medium.tree;

import java.util.HashMap;
import java.util.Map;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/17 23:08
 * Description:105-从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class BuildTree {


    /**
     * 解法：前序（根左右），中序(左根右)
     * 思路:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength != inLength) {
            throw new RuntimeException("fuck");
        }

        //获取中序遍历情况下，对应的角标及值的印射关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLength, 0, inLength, map);

    }

    private TreeNode buildTree(int[] preOrder,
                               int preLeft,
                               int preRight,
                               int inLeft,
                               int inRight,
                               Map<Integer, Integer> map) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        //前序遍历的的第一个节点为根节点
        TreeNode root = new TreeNode(preOrder[preLeft]);

        //获取中序遍历情况下，对应的角标值
        int index = map.get(root.val);

        //构造左子树
        root.left = buildTree(preOrder, preLeft + 1, index - inLeft + preLeft, inLeft, index - 1, map);
        //构造右子树
        root.right = buildTree(preOrder, index - inLeft + preLeft + 1, preRight, index + 1, inRight, map);
        return root;
    }
}
