package simple.tree;

import java.util.LinkedList;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/16 11:05
 * Description:对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */


public class IsSymmetric {

    /**
     * 解法：递归+层序遍历
     * 思路：
     * 通过「同步移动」两个指针的方法来遍历这棵树，p 指针和 q 指针一开始都指向这棵树的根，
     * 随后 p 右移时，q 左移，p 左移时，q 右移。每次检查当前 p 和 q 节点的值是否相等，如果相等再判断左右子树是否对称。
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public boolean isSymmetricSolution1(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    /**
     * 解法：额外空间+层序遍历
     * 思路：
     * 「方法一」中我们用递归的方法实现了对称性的判断，那么如何用迭代的方法实现呢？
     * 首先我们引入一个队列，这是把递归程序改写成迭代程序的常用方法。
     * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，
     * 而且它们的子树互为镜像），然后将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public boolean isSymmetricSolution2(TreeNode root) {
        return check2(root, root);
    }


    private boolean check2(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            //当节点为空的时候跳出循环
            if (n1 == null && n2 == null) {
                continue;
            }

            //只有有一个节点为空，直接返回false
            if (n1 == null || n2 == null) {
                return false;
            }
            //如果值不相等，直接返回false
            if (n1.val != n2.val) {
                return false;
            }

            queue.offer(n1.left);
            queue.offer(n2.right);

            queue.offer(n1.right);
            queue.offer(n2.right);
        }

        return true;
    }
}
