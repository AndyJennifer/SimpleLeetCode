package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2020/10/22 10:45
 * Description:
 * 11-盛最多水的容器 {@link medium.array.MaxArea}
 * 15-三数之和 {@link medium.array.ThreeSum}
 * 18-四数之和 {@link medium.array.FourSum}
 */


class Day3 {

    ///////////////////////////////////////////////////////////////////////////
    // 盛最多水的容器
    ///////////////////////////////////////////////////////////////////////////
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int result = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(result, ans);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 三数之和
    ///////////////////////////////////////////////////////////////////////////
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        //先对数组排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                List<Integer> ans = new ArrayList<>();

                int result = nums[left] + nums[right];
                if (result == -nums[i]) {
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    ans.add(nums[i]);
                    list.add(ans);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (result < -nums[i]) {
                    left++;
                } else {
                    right--;
                }

            }

        }
        return list;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 四数之和
    ///////////////////////////////////////////////////////////////////////////
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null && nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 4; i++) {


            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[i + 1] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[j] + nums[j + 1] + nums[j + 2] + nums[j + 3] > target) {
                    break;
                }

                if (nums[j] + nums[j + 1] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                int left = j + 1;
                int right = length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        list.add(ans);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;

                        while (left < right && nums[right] == nums[right] - 1) {
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
        return list;
    }

}
