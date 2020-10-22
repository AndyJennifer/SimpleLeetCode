package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2018/5/22 00:08
 * Description: 15-三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -1});
    }

    /**
     * 时间复杂度
     * 排序O(nlogn)
     * 搜索解O(n2)
     * <p>
     * 空间复杂度O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        //先对数组排序（快排）,利用排序避免重复答案
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int first = 0; first < length; first++) {
            //排除和上一次相同的数
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            List<List<Integer>> result = twoSum(nums, first + 1, length - 1, -nums[first], nums[first]);
            list.addAll(result);
        }
        return list;

    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请该数组中找出和为目标值的那两个整数，并以集合的形式返回
     *
     * @param nums   排序后的目标数组
     * @param start  开始位置
     * @param end    结束位置
     * @param target 目标值
     * @param value  当前位置对于的值
     * @return
     */
    private static List<List<Integer>> twoSum(int[] nums, int start, int end, int target, int value) {
        List<List<Integer>> list = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                //如果找到目标和，则加入解
                List<Integer> result = new ArrayList<>();
                result.add(value);
                result.add(nums[start]);
                result.add(nums[end]);
                list.add(result);

                //跳过重复解
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }

                start++;

                while (start < end && nums[end] == nums[end] - 1) {
                    end--;
                }
                end--;
            } else if (sum < target) {
                //如果和比目标值小，则左指针往右移动
                start++;
            } else {
                //如果和比目标值大，则右指针往左移动
                end--;
            }
        }
        return list;
    }
}
