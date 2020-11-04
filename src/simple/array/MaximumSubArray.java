package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2018/5/2 13:57
 * Description: 最大子序之和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class MaximumSubArray {
    public static void main(String[] args) {
//        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    /**
     * 思路：大概是遍历当前元素，当走到某个位置时，判断是否比上个大，同时记录当前的和(动态规划)
     * ai:表示某个位置上的数
     * f(i) = Math.max(f(i)+ai,ai)
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(num + pre, num);
            ans = Math.max(pre, ans);
        }
        return ans;
    }


}
