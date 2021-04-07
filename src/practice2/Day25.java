package practice2;

import java.util.*;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/21 10:31
 * Description:
 * 106-从中序与后序遍历序列构造二叉树{@link medium.tree.BuildTree2}
 * 107-二叉树的层次遍历2{@link simple.tree.LevelOrderBottom}
 * 108-将有序数组转换为二叉搜索树{@link simple.tree.SortedArrayToBST}
 */


class Day25 {

    ///////////////////////////////////////////////////////////////////////////
    // 从中序与后序遍历序列构造二叉树
    ///////////////////////////////////////////////////////////////////////////

    private int postIndex;

    public TreeNode buildTree2Solution1(int[] inorder, int[] postorder) {
        int inorderLength = inorder.length;
        int postorderLength = postorder.length;
        postIndex = postorderLength - 1;
        if (inorderLength != postorderLength) {
            throw new RuntimeException("fuck");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree2(postorder, map, 0, inorderLength - 1);

    }

    private TreeNode buildTree2(int[] posorder, Map<Integer, Integer> map, int left, int right) {

        if (left > right) {
            return null;
        }
        int val = posorder[postIndex--];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);

        root.right = buildTree2(posorder, map, index + 1, right);
        root.left = buildTree2(posorder, map, left, index - 1);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的层次遍历2
    ///////////////////////////////////////////////////////////////////////////
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
            res.add(0, list);
        }
        return res;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 将有序数组转换为二叉搜索树
    ///////////////////////////////////////////////////////////////////////////

    public TreeNode sortedArrayToBSTSolution(int[] nums) {
        return buildBSTTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildBSTTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBSTTree(nums, left, mid - 1);
        root.right = buildBSTTree(nums, mid + 1, right);
        return root;
    }
}
