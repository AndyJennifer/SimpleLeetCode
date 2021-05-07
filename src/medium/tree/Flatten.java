package medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/1/11 16:04
 * Description: 114-二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Flatten {


    /**
     * 解法1：递归
     * 思路：前序遍历递归，{@link domain.tree.Tree#preOrder(TreeNode)} }
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public void flattenSolution1(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        //前序遍历，并将节点添加到集合中
        preorderTraversal(root, list);

        //遍历集合，构造样式，让上一个节点的right节点指向下一个节点
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    /**
     * 解法2：使用栈的方式，模拟递归
     * 思路：前序遍历递归，{@link domain.tree.Tree#preOrder(TreeNode)} }
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public void flattenSolution2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        //遍历集合，构造样式，让上一个节点的right节点指向下一个节点
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    /**
     * 解法3：寻找前驱节点
     * 思路：
     * 对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public void flattenSolution3(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            //判断左子树是否为空
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                //1.找到左子树最右的节点
                while (pre != null) {
                    pre = pre.right;
                }
                //2.将最右节点的右节点指向cur.right
                pre.right = cur.right;
                //3.将上一个节点的左节点置为null
                cur.left = null;
                //4.将左子树移动到右边去
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    /**
     * 解法4：后序遍历+递归
     */
    public void flattenSolution4(TreeNode root) {
        if (root == null) {
            return;
        }

        //拉平左右子树
        flattenSolution4(root.left);
        flattenSolution4(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        //把根节点的左节点置位null
        root.left = null;
        //让根节点的右节点指向左节点
        root.right = left;

        //找到根节点右子树的最右节点
        TreeNode p = root.right;
        while (p != null) {
            p = p.right;
        }
        //将原右子树接到右子树最右节点
        p.right = right;
    }

}
