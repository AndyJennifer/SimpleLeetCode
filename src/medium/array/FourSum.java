package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2020/10/21 20:36
 * Description: 18-四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 */


public class FourSum {

    /**
     * 时间复杂度
     * 排序O(nlogn)
     * 搜索解O(n3)
     * <p>
     * 空间复杂度O(1)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        //如果当前数组的长度小于4直接返回
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        //先排序数组
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {
            //第一次循环，跳过重复的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //在确定第一个数之后，如果nums[i]+nums[i+1]+nums[i+3]>target
            //说明此时剩下的三个数无论取什么值，四数之后一定大于target，因此退出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //在确定第一个数之后，如果nums[i]+nums[n-3]+nums[n-2]+nums[n-1]<target
            //说明此时剩下的三个数无论取什么值，四数之和一定小于target,因此第一重循环进入下一轮，枚举nums[i+1]
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {

                //如果第二次循环的数与第一次的数一样，重新进入下一轮，枚举nums[j+1]
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //在确定前两个数之后，如果nums[i]+nums[j]+nums[j+1]+nums[j+2]
                //说明剩下的两个数无论取什么值，四数之和一定小于target,所以跳出循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                //在确定前两个数之后，如果nums[i]+nums[j]+nums[length-1]+nums[length-2]
                //说明此时剩下的两个数无论取什么值，四数之和一定小于target,因此第一重循环进入下一轮，枚举nums[j+1]
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                //下面是三数求和的思路
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

}
