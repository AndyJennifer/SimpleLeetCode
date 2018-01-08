/**
 * Author:  andy.xwt
 * Date:    2017/12/28 10:48
 * Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 11};
        twoSum(nums, 10);
    }

    /**
     * 时间复杂度（O2）
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }
}
