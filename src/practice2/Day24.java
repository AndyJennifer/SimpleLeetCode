package practice2;

import java.util.*;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/17 16:03
 * Description:
 * 102-二叉树的层序遍历{@link medium.tree.LevelOrder}
 * 104-二叉树的最大深度{@link simple.tree.MaxDepth}
 * 105-从前序与中序遍历序列构造二叉树{@link medium.tree.BuildTree}
 */


class Day24 {

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的层序遍历
    ///////////////////////////////////////////////////////////////////////////
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Queue<TreeNode> deque = new LinkedList<>();

        deque.offer(root);

        while (!deque.isEmpty()) {

            List<Integer> res = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }

                res.add(node.val);

            }
            list.add(res);
        }
        return list;

    }


    ///////////////////////////////////////////////////////////////////////////
    // 二叉树的最大深度
    ///////////////////////////////////////////////////////////////////////////

    public int maxDepthSolution1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxDepthSolution1(root.left), maxDepthSolution1(root.right)) + 1;
    }


    public int maxDepthSolution2(TreeNode root) {
        int res = 0;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 从前序与中序遍历序列构造二叉树
    ///////////////////////////////////////////////////////////////////////////
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;

        if (preLength != inLength) {
            throw new RuntimeException("fuck");
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLength, map, 0, inLength);

    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               HashMap<Integer, Integer> map, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(root.val);

        //x- (preleft+1)  = index-1 -inleft
        //x  = index-inleft+preleft

        //preleft prelet+1   index-inleft+preleft  index-inleft+preleft+1     preRight
        //inleft  index -1   index  index+1      inRight
        root.left = buildTree(preorder, preLeft + 1, index - inLeft + preLeft, map, inLeft, index - 1);
        root.right = buildTree(preorder, index - inLeft + preLeft + 1, preRight, map, index + 1, inRight);

        return root;


    }
}
