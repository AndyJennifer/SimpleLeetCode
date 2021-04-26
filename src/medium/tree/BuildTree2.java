package medium.tree;

import java.util.HashMap;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/21 10:51
 * Description:106-从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class BuildTree2 {

    private int posIndex = 0;


    /**
     * 解法：
     * 思路:同105-从前序与中序遍历序列构造二叉树{@link medium.tree.BuildTree
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     */
    public TreeNode buildTree2Solution1(int[] inorder, int[] postorder) {
        int inLength = inorder.length;
        int postLength = postorder.length;
        posIndex = postLength;
        if (inLength != postLength) {
            throw new RuntimeException("fuck");
        }

        //建立hash表，防止重复迭代
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, inLength, postorder, map);
    }

    private TreeNode buildTree(int inLeft, int inRight, int[] postorder, HashMap<Integer, Integer> map) {

        // 如果这里没有节点构造二叉树了，就结束
        if (inLeft > inRight) {
            return null;
        }
        //选择 post_idx 位置的元素作为当前子树根节点
        int rootValue = postorder[posIndex--];
        TreeNode root = new TreeNode(rootValue);


        int index = map.get(rootValue);

        //先构造右子树，是因为后序遍历，根节点的上一个节点为右节点
        root.right = buildTree(index + 1, inRight, postorder, map);
        //构造左子树
        root.left = buildTree(inLeft, index - 1, postorder, map);
        return root;
    }

}
