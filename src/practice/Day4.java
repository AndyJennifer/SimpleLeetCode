package practice;

/**
 * Author:  andy.xwt
 * Date:    2020/11/2 21:51
 * Description:
 * 26-删除排序数组中的重复项 {@link simple.array.RemoveDuplicates}
 * 27-移除元素{@link simple.array.RemoveElement}
 * 35-搜索插入元素{@link simple.array.SearchInsertPosition}
 */


class Day4 {

    ///////////////////////////////////////////////////////////////////////////
    // 删除排序数组中的重复项
    ///////////////////////////////////////////////////////////////////////////

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 移除元素
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    // 搜索插入位置
    ///////////////////////////////////////////////////////////////////////////

    public int searchInsertSolution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsertSolution2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = ((left + right) >> 2) + left;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
