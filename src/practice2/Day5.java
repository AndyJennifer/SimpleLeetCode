package practice2;

import medium.array.RemoveDuplicates2;
import simple.array.MaximumSubArray;
import simple.array.PlusOne;

/**
 * Author:  andy.xwt
 * Date:    2020/11/3 21:54
 * Description:
 * 53-最大子序之和{@link MaximumSubArray}
 * 66-加1{@link PlusOne}
 * 80-删除排序排序数组的重复项2{@link RemoveDuplicates2 }
 */


class Day5 {

    ///////////////////////////////////////////////////////////////////////////
    // 最大子序之和 f(i) = Math.max(f(i-1)+ai,ai)
    ///////////////////////////////////////////////////////////////////////////
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;

    }

    ///////////////////////////////////////////////////////////////////////////
    // 加1
    ///////////////////////////////////////////////////////////////////////////
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //这里处理全是9的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 删除排序排序数组的重复项2
    ///////////////////////////////////////////////////////////////////////////
    public int removeDuplicatesSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int i = 1;
        int length = nums.length;

        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    //这里开始交换位置
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j] = nums[j - 1];
                    }
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
            i++;

        }
        return length;
    }

    public int removeDuplicatesSolution2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
