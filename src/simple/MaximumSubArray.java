package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/2 13:57
 * Description:
 */

public class MaximumSubArray {
    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    /**
     * 思路：大概是遍历当前元素，当走到某个位置时，判断是否比上个大，同时记录当前的和
     */
    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];//用来记录上一顺序的最大和值
        temp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = Math.max(temp[i - 1] + nums[i], nums[i]);//上一顺序和值与当前角标对应值进行比较
            max = Math.max(temp[i], max);//与上一顺序的最大和值进行比较。
        }
        return max;
    }

}
