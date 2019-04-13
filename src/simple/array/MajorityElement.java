package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2019-04-13 22:18
 * Description: 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

public class MajorityElement {

    public static void main(String[] args) {
        int result = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(result);
    }

    /**
     * 解题思路：
     * 解法1：
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     * 解法2：
     * 将该数组进行排序，取1/2位置的元素
     */
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i+1];
                }
            }
        }
        return res;
    }
}
