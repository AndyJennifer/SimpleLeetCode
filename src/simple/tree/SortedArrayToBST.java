package simple.tree;

import domain.tree.TreeNode;

/**
 * Author:  andy.xwt
 * Date:    2020/12/23 21:11
 * Description:将有序数组转换为二叉搜索树
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class SortedArrayToBST {

    /**
     * 解法：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
     * 思路：二叉树的中序遍历，就是数组的升序
     * 时间复杂度:O(n)
     * 空间复杂度:O(logn)
     */
    public TreeNode sortedArrayToBSTSolution(int[] nums) {
        return buildTree1(nums, 0, nums.length - 1);
//        return buildTree2(nums, 0, nums.length - 1);
//        return buildTree3(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree1(nums, left, mid - 1);
        root.right = buildTree1(nums, mid + 1, right);
        return root;
    }


    private TreeNode buildTree2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree2(nums, left, mid - 1);
        root.right = buildTree2(nums, mid + 1, right);
        return root;
    }


}
