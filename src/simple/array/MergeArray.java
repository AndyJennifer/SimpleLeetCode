package simple.array;

import utils.ArrayUtils;

/**
 * Author:  andy.xwt
 * Date:    2019-03-12 01:20
 * Description: 合并两个排序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */

public class MergeArray {

    public static final int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    public static final int[] nums2 = new int[]{2, 5, 6};


    /**
     * 思路，三指针
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public static void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            //比较两个排序数组中最大的值，谁大在在最后，同时角标减一
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        //因为nums1的长度大于nums2，所以只nums没有遍历完的情况，那么需要重新覆盖位置
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        ArrayUtils.printArray(nums1);

    }


    public static void main(String[] args) {
        mergeSolution1(nums1, 3, nums2, 3);
    }
}
