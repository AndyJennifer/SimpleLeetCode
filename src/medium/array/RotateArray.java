package medium.array;

/**
 * Author:  andy.xwt
 * Date:    2020/11/10 13:50
 * Description:旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class RotateArray {
    /**
     * 解决方法1：暴力
     * 思路：最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
     * 时间复杂度O(n*k)
     * 空间复杂度O(1)
     */
    public void rotateSolution1(int[] nums, int k) {
        int temp, previous;
        //数组依次向前移动
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 解决方法2
     * 思路：我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为
     * i的我们把它放到(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public void rotateSolution2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 解法3：
     * 思路：
     * 1.先反转原始数组
     * 2.拿到第一步结果后，反转前k个数字
     * 3.拿到第二步结果后，反转n-k个数字
     */
    public void rotateSolution3(int[] nums, int k) {
        //这里取余是为了计算角标
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
