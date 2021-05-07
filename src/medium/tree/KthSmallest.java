package medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/26 16:18
 * Description:230-二叉树搜索中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */

public class KthSmallest {


    /**
     * 解法2：根据搜索树的性质，使用额外数组来存储中序遍历后的二叉搜索树
     */
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


    /**
     * 解法2:直接使用中序遍历递归方式
     * 中序遍历二叉树，注意二叉搜索树的特性：中序遍历是升序
     */

    private int res = 0;
    private int count = 0;


    public int kthSmallestSolution2(TreeNode root, int k) {
        find(root, k);
        return res;
    }

    public void find(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        find(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        find(root, k);
    }

    /**
     * 解法3:使用栈来模拟中序遍历
     */
    public int kthSmallestSolution3(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            count++;
            if (count == k) {
                return root.val;
            }
            root = root.right;
        }
        return 0;

    }


}
