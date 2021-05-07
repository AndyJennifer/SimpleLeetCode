package simple.tree;

import java.util.LinkedList;
import java.util.Queue;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/24 19:57
 * Description: 112-路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class HasPathSum {

    /**
     * 解法：递归
     * 思路:
     * 观察要求我们完成的函数，我们可以归纳出它的功能：询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum。
     * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
     * 不难发现这满足递归的性质，若当前节点就是叶子节点，那么我们直接判断 sum 是否等于 val 即可
     * （因为路径和已经确定，就是当前节点的值，我们只需要判断该路径和是否满足条件）。若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */
    public boolean hasPathSumSolution1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //判断是否是叶子节点，
        if (root.left == null && root.right == null) {
            //如果是叶子节点
            return root.val == sum;
        }
        return hasPathSumSolution1(root.left, sum - root.val)
                || hasPathSumSolution1(root.right, sum - root.val);
    }

    /**
     * 解法：广度优先搜索
     * 思路:首先我们可以想到使用广度优先搜索的方式，记录从根节点到当前节点的路径和，以防止重复计算。
     * 这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */
    public boolean hasPathSumSolution2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.offer(root);
        valueQueue.offer(root.val);

        while (!nodeQueue.isEmpty() && !valueQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            int temp = valueQueue.poll();

            //判断叶子节点中的值与传入的sum是否相等
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                //加上当前左节点的值
                valueQueue.offer(temp + node.left.val);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                //加上当前右节点的值
                valueQueue.offer(temp + node.right.val);
            }

        }
        return false;
    }

}
