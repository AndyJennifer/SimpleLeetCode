package simple.tree;

import java.util.LinkedList;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/15 23:50
 * Description:相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */


public class IsSameTree {


    ///////////////////////////////////////////////////////////////////////////
    //树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；
    //常见的 DFS ： 先序遍历、中序遍历、后序遍历；
    //常见的 BFS ： 层序遍历（即按层遍历）。
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 解法1：深度优先,先序遍历（先遍历当前节点，在依次遍历左右叶子节点)
     * 思路：
     * 如果两个二叉树都为空，则两个二叉树相同。如果两个二叉树中有且只有一个为空，则两个二叉树一定不相同。
     * 如果两个二叉树都不为空，那么首先判断它们的根节点的值是否相同，若不相同则两个二叉树一定不同，
     * 若相同，再分别判断两个二叉树的左子树是否相同以及右子树是否相同。
     * 这是一个递归的过程，因此可以使用深度优先搜索，递归地判断两个二叉树是否相同。
     * <p>
     * 时间复杂度:O(min(p.length,q.length)
     * 空间复杂度:O(min(p.length,q.length)
     */
    public boolean isSameTreeSolution1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            //如果对应节点都为空，返回false
            return true;
        } else if (p == null || q == null) {
            //如果有一个为null,返回false
            return false;
        } else if (p.val != q.val) {
            //如果节点的值不相等，返回false
            return false;
        } else {
            return isSameTreeSolution1(p.left, q.left) && isSameTreeSolution1(p.right, q.right);
        }

    }

    /**
     * 解法：广度优先，层序遍历
     * <p>
     * 也可以通过广度优先搜索判断两个二叉树是否相同。同样首先判断两个二叉树是否为空，如果两个二叉树都不为空，
     * 则从两个二叉树的根节点开始广度优先搜索。
     * <p>
     * 使用两个队列分别存储两个二叉树的节点。初始时将两个二叉树的根节点分别加入两个队列。每次从两个队列各取出一个节点，进行如下比较操作。
     * <p>
     * 比较两个节点的值，如果两个节点的值不相同则两个二叉树一定不同；
     * <p>
     * 如果两个节点的值相同，则判断两个节点的子节点是否为空，如果只有一个节点的左子节点为空，或者只有一个节点的右子节点为空，
     * 则两个二叉树的结构不同，因此两个二叉树一定不同；
     * <p>
     * 如果两个节点的子节点的结构相同，
     * 则将两个节点的非空子节点分别加入两个队列，子节点加入队列时需要注意顺序，
     * 如果左右子节点都不为空，则先加入左子节点，后加入右子节点。
     * <p>
     * 如果搜索结束时两个队列同时为空，则两个二叉树相同。如果只有一个队列为空，则两个二叉树的结构不同，因此两个二叉树不同。
     * <p>
     * 时间复杂度:O(min(p.length,q.length)
     * 空间复杂度:O(min(p.length,q.length)
     */
    public boolean isSameTreeSolution2(TreeNode p, TreeNode q) {


        //如果当前节点都为null,返回true
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            //如果有一个节点为空，则返回false
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            //如果两个节点的值不相等，那么直接返回false
            if (n1.val != n2.val) {
                return false;
            }

            TreeNode left1 = n1.left;
            TreeNode left2 = n2.left;

            TreeNode right1 = n1.right;
            TreeNode right2 = n2.right;

            //如果有一个节点为空，返回false
            if (left1 == null ^ left2 == null) {
                return false;
            }

            if (right1 == null ^ right2 == null) {
                return false;
            }

            if (left1 != null) {
                q1.offer(left1);
            }

            if (right1 != null) {
                q1.offer(right1);
            }

            if (left2 != null) {
                q2.offer(left2);
            }
            if (right2 != null) {
                q2.offer(right2);
            }
        }

        //因为是按照层次遍历的，所以判断两个结合是否为空就行了
        return q1.isEmpty() && q2.isEmpty();
    }
}
