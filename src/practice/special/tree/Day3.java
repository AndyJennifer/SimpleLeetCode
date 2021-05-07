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
 * 226-翻转二叉树{@link simple.tree.InvertTree}
 * 98-平衡二叉树{@link simple.tree.IsBalanced}
 * 100-相同的树{@link simple.tree.IsSameTree}
 * 101-对称二叉树{@link simple.tree.IsSymmetric}
 * 112-路径总和{@link simple.tree.HasPathSum}
 * 116-填充每个节点的下一个右侧节点指针{@link simple.tree.ConnectionNode}
 */

class Day3 {

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

    ///////////////////////////////////////////////////////////////////////////
    // 将有序数组转换为二叉搜索树
    ///////////////////////////////////////////////////////////////////////////

}
