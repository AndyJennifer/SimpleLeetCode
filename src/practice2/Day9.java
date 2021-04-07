package practice2;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2020/11/11 16:01
 * Description:
 * 219-存在重复元素2{@link simple.array.ContainDuplicate2}
 * 414-第三大的数 {@link simple.array.ThirdMax}
 * 485-最大连续1的个数{@link simple.array.FindMaxConsecutiveOnes}
 */


class Day9 {

    ///////////////////////////////////////////////////////////////////////////
    // 存在重复元素2
    ///////////////////////////////////////////////////////////////////////////

    public boolean containNearByDuplicateSolution1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < i; j++) {
                if (nums[i] == nums[i - j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containNearByDuplicateSolution2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(i - k);
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 第三大的数
    ///////////////////////////////////////////////////////////////////////////

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int count = nums.length;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == first || num == second || num == third) {
                count--;
                continue;
            }
            if (num > first) {
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


        return count >= 3 ? third : first;

    }

    ///////////////////////////////////////////////////////////////////////////
    //最大连续1的个数
    ///////////////////////////////////////////////////////////////////////////
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

}
