package simple.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2019-03-07 23:37
 * Description:
 * 存在重复元素
 * <p>
 * 相似题型:
 * {@link ContainDuplicate2}
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 */

public class ContainDuplicate {

    /**
     * 解法1：暴力枚举
     * 时间复杂度:O(N^2)
     */
    public boolean containDuplicateSolution1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法2：排序
     * 思路：如果存在重复元素，排序后它们应该相邻。
     * 时间复杂度：O(nlogn)
     */
    public boolean containDuplicateSolution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 解法3：Hash表
     * 时间复杂度:O(n)
     * 空间复杂度：O(n)
     */
    public boolean containDuplicateSolution3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;

    }

}
