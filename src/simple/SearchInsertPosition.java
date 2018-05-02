package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/2 11:12
 * Description:搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 2);
    }

    public static int searchInsert(int[] nums, int target) {
        int in = 0, out;
        for (out = 0; out < nums.length; out++) {
            in = out;
            while (in > 0 && nums[in - 1] >= target) {//如果下一个比上一个大
                --in;//继续移动
            }
            if (in == nums.length - 1 && nums[out] < target) {//判断如果最后一个数字还比他小，则插入最后
                return nums.length;

            }
        }
        return in;
    }
}
