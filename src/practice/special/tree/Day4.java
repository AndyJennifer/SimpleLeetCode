package practice.special.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/5/7 00:14
 * Description:
 * 108-将有序数组转换为二叉搜索树{@link simple.tree.SortedArrayToBST}
 * 654-最大二叉树{@link medium.tree.ConstructMaxBinaryTree}
 * 105-从前序与中序遍历序列构造二叉树{@link medium.tree.BuildTree}
 * 106-从中序与后序遍历序列构造二叉树{@link medium.tree.BuildTree2}
 * 297-二叉树的序列化与反序列化{@link difficult.tree.Serialize}
 * 652-寻找重复的子树{@link medium.tree.FindDuplicateSubTree}
 */

class Day4 {


    ///////////////////////////////////////////////////////////////////////////
    // 将有序数组转换为二叉搜索树
    ///////////////////////////////////////////////////////////////////////////
    public TreeNode sortedArrayToBSTSolution1(int[] nums) {
        return buildTree1(nums, 0, nums.length);
    }

    public TreeNode buildTree1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildTree1(nums, left, middle - 1);
        root.right = buildTree1(nums, middle + 1, right);
        return root;
    }


    public TreeNode sortedArrayToBSTSolution2(int[] nums) {
        return buildTree2(nums, 0, nums.length);
    }

    public TreeNode buildTree2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildTree1(nums, left, middle - 1);
        root.right = buildTree1(nums, middle + 1, right);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 最大二叉树
    ///////////////////////////////////////////////////////////////////////////

    public TreeNode constructMaxBinaryTreeSolution1(int[] nums) {
        return buildMaxTree(nums, 0, nums.length);
    }

    public TreeNode buildMaxTree(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i < end; i++) {
            int value = nums[i];
            if (value > max) {
                max = value;
                index = 0;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = buildMaxTree(nums, start, index - 1);
        root.right = buildMaxTree(nums, index + 1, end);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 从前序与中序遍历序列构造二叉树
    ///////////////////////////////////////////////////////////////////////////
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength != inLength) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelp(preorder, 0, preLength, 0, inLength, map);
    }


    public TreeNode buildTreeHelp(int[] preorder,
                                  int preLeft,
                                  int preRight,
                                  int inLeft,
                                  int inRight,
                                  Map<Integer, Integer> map) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(root.val);

        root.left = buildTreeHelp(preorder, preLeft + 1, index - inLeft + preLeft, inLeft, index - 1, map);
        root.right = buildTreeHelp(preorder, index - inLeft + preLeft + 1, preRight, index + 1, inRight, map);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 从中序与后序遍历序列构造二叉树
    ///////////////////////////////////////////////////////////////////////////

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int inLength = inorder.length;
        int postLength = postorder.length;
        if (inLength != postLength) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelp2(postorder, 0, inLength, 0, postLength, map);
    }

    public TreeNode buildTreeHelp2(int[] postOrder, int inLeft, int inRight, int postLeft, int postRight, Map<Integer, Integer> map) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postRight]);
        int index = map.get(root.val);
        root.right = buildTreeHelp2(postOrder, index + 1, inRight, postRight - inRight + index, postRight - 1, map);
        root.left = buildTreeHelp2(postOrder, inLeft, index - 1, postLeft, postRight - inRight + index - 1, map);
        return root;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的序列化与反序列化
    ///////////////////////////////////////////////////////////////////////////

    public static final String NULL = "#";
    public static final String SPL = ",";

    //前序遍历
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serializeHelp1(root, sb);
    }

    public String serializeHelp1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPL);
        } else {
            sb.append(root.val).append(SPL);
            serializeHelp1(root.left, sb);
            serializeHelp1(root.right, sb);
        }
        return sb.toString();
    }

    public TreeNode deserialize1(String data) {
        if (data == null) {
            return null;
        }
        LinkedList<String> list = new LinkedList<>();
        String[] split = data.split(SPL);

        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        return deserializeHelp1(list);
    }

    public TreeNode deserializeHelp1(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.removeFirst();
        if (s.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeHelp1(list);
        root.right = deserializeHelp1(list);
        return root;
    }

    //后续遍历
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serializeHelp2(root, sb);
    }

    public String serializeHelp2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPL);
        } else {
            serializeHelp2(root.left, sb);
            serializeHelp2(root.right, sb);
            sb.append(root.val).append(SPL);
        }
        return sb.toString();
    }

    public TreeNode deserialize2(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.split(SPL);
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        return deserializeHelp2(list);
    }

    public TreeNode deserializeHelp2(LinkedList<String> list) {
        if (list == null) {
            return null;
        }
        String s = list.removeLast();
        if (s.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.right = deserializeHelp1(list);
        root.left = deserializeHelp1(list);
        return root;
    }

    //层序遍历
    public String serialize3(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(NULL).append(SPL);
                } else {
                    sb.append(node.val).append(SPL);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize3(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.split(SPL);
        String rootValue = split[0];
        TreeNode node = new TreeNode(Integer.parseInt(rootValue));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        for (int i = 1; i < split.length; i++) {
            TreeNode root = queue.poll();

            //构造左节点
            String leftValue = split[i++];
            if (leftValue.equals(NULL)) {
                root.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(leftValue));
                root.left = left;
                queue.offer(left);
            }

            //构造右节点
            String rightValue = split[i++];
            if (rightValue.equals(NULL)) {
                root.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(rightValue));
                root.right = right;
                queue.offer(right);
            }
        }
        return node;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 寻找重复的子树
    ///////////////////////////////////////////////////////////////////////////
    public List<TreeNode> findDuplicateSubtreesSolution1(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        find(root, map, list);
        return list;
    }

    public String find(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(NULL).append(SPL);
        } else {
            String left = find(root.left, map, list);
            String right = find(root.right, map, list);
            String tree = sb.append(root.val).append(SPL).append(left).append(SPL).append(right).toString();
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            if (map.get(tree) == 2) {
                list.add(root);
            }
        }

        return sb.toString();
    }
}
