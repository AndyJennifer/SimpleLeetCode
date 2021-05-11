package practice.special.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/5/6 19:26
 * Description:
 * <p>
 * 二叉搜索树(Binary Search Tree)的特点：
 * 1、对于 BST 的每一个节点node，左子树节点的值都比node的值要小，右子树节点的值都比node的值大。
 * 2、对于 BST 的每一个节点node，它的左侧子树和右侧子树都是 BST。
 * 3、BST 的中序遍历结果是有序的（升序）。
 * <p>
 * 230-二叉树搜索中第K小的元素{@link medium.tree.KthSmallest}
 * 538-把二叉树搜索树转换为累加树{@link medium.tree.ConvertBst}
 * 98-验证二叉搜索树{@link medium.tree.IsValidBST}
 * 700-二叉搜索树中的搜索{@link medium.tree.SearchBTS}
 * 701-二叉搜索树中的插入操作{@link medium.tree.InsertIntoBTS}
 * 450-删除二叉搜索树中的节点{@link medium.tree.DeleteNode}
 */

class Day2 {

    ///////////////////////////////////////////////////////////////////////////
    // 二叉树搜索中第K小的元素
    ///////////////////////////////////////////////////////////////////////////
    public int kthSmallestSolution1(TreeNode root, int k) {
        List<Integer> list = kthHelp1(root, new ArrayList<>());
        return list.get(k - 1);
    }

    public List<Integer> kthHelp1(TreeNode root, List<Integer> list) {
        if (root != null) {
            kthHelp1(root.left, list);
            list.add(root.val);
            kthHelp1(root.right, list);
        }
        return list;
    }

    private int res = 0;
    private int count = 0;

    public int kthSmallestSolution2(TreeNode root, int k) {
        kthHelp2(root, k);
        return res;
    }

    public void kthHelp2(TreeNode root, int k) {
        if (root != null) {
            kthHelp2(root.left, k);
            count++;
            if (count == k) {
                res = root.val;
            }
            kthHelp2(root.right, k);
        }
    }


    public int kthSmallestSolution3(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.right;
            }
            root = deque.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 把二叉树搜索树转换为累加树
    ///////////////////////////////////////////////////////////////////////////

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 验证二叉搜索树
    ///////////////////////////////////////////////////////////////////////////

    public boolean isValidBSTSolution1(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.left.val >= maxValue) {
            return false;
        }
        if (root.right.val <= minValue) {
            return false;
        }
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }


    public boolean isValidBSTSolution2(TreeNode root) {
        int pre = Integer.MIN_VALUE;
        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉搜索树中的搜索
    ///////////////////////////////////////////////////////////////////////////

    public TreeNode searchBSTSolution1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBSTSolution1(root.left, val);
        } else {
            return searchBSTSolution1(root.right, val);
        }
    }

    public TreeNode searchBSTSolution2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二叉搜索树中的插入操作
    ///////////////////////////////////////////////////////////////////////////
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


    public TreeNode insertIntoBSTSolution2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > val) {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 删除二叉搜索树中的节点
    ///////////////////////////////////////////////////////////////////////////

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode min = getMin(root);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
