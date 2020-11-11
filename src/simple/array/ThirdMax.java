package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2020/11/11 16:17
 * Description: 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class ThirdMax {

    /**
     * 思路：用三个变量来存储位置，如果大于任何一个那么就交换
     * 时间复杂度：O(N^2)
     */
    public int thirdMax(int[] nums) {

        //如果数组长度为0，那么就返回-1
        if (nums == null || nums.length == 0)
            return -1;

        //如果长度为1，则返回第一个元素
        if (nums.length == 1) {
            return nums[0];
        }
        //如果长度为2，则谁大谁返回
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int len = nums.length;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int num : nums) {
            //遇到重复的数字，那么就跳过
            if (num == first || num == second || num == third) {
                len--;
                continue;
            }
            if (num > first) {
                //大于第一个数，则依次替换位置
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }
        //最后判断长度，大于3则返回第三位置上的数，反之返回第一个
        return len >= 3 ? third : first;
    }
}
