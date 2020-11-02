package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2018/5/2 11:12
 * Description:搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 */

public class SearchInsertPosition {

    /**
     * 在不考虑时间复杂度的基础上，可以直接这么做，时间复杂度O(N)
     */
    public static int searchInsertSolution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    /**
     * 考虑时间复杂度，那么就可以使用折半法，时间复杂度O(logN)
     */
    public static int searchInsertSolution2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                //如果当前的数，大于等于当前的值，那么就往下找
                ans = mid;
                right = mid - 1;
            } else {
                //如果当前的数，比目标值小，那么需要往前找
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int result = searchInsertSolution2(new int[]{1, 3, 5, 6}, 2);
    }
}
