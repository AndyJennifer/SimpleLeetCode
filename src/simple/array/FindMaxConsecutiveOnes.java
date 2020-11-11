package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2020/11/11 17:41
 * Description:最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class FindMaxConsecutiveOnes {

    /**
     * 题目的约束让这个问题变得简单，使得我们可以在一次遍历解决它。
     * <p>
     * 算法：
     * <p>
     * 用一个计数器 count 记录 1 的数量，另一个计数器 maxCount 记录当前最大的 1 的数量。
     * 当我们遇到 1 时，count 加一。
     * 当我们遇到 0 时：
     * 将 count 与 maxCount 比较，maxCoiunt 记录较大值。
     * 将 count 设为 0。
     * 返回 maxCount。
     *
     * 时间复杂度:O(N)
     * 控件复杂度:O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }

}
