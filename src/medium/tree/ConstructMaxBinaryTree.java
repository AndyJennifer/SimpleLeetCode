package medium.tree;


import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2021/4/19 10:47
 * Description: 654-最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ConstructMaxBinaryTree {

    public TreeNode solution1(int[] nums) {
        return build(nums, 0, nums.length);
    }

    /**
     * 解法：前序遍历
     */
    private TreeNode build(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        //找到数组中最大的元素
        int maxValue = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) {
                index = i;
                maxValue = nums[i];
            }
        }
        //构造根节点
        TreeNode root = new TreeNode(maxValue);
        //构造左右节点
        root.left = build(nums, start, index - 1);
        root.right = build(nums, index + 1, end);

        return root;
    }
}
