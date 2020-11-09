package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2020/11/9 17:21
 * Description:两数之和2
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class TwoSum2 {

    /**
     * 这题的解法1：可以使用TwoSum1的解法{@link TwoSum},但是并不能使用"有序"的这个特性
     */
    public int[] twoSumSolution1(int[] numbers, int target) {
        return null;
    }

    /**
     * 解法2：二分查找
     * 在数组中找到两个数，使得它们的和等于目标值，可以首先固定第一个数，
     * 然后寻找第二个数，第二个数等于目标值减去第一个数的差。利用数组的有序性质，
     * 可以通过二分查找的方法寻找第二个数。为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找。
     */
    public int[] twoSumSolution2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int height = numbers.length - 1;
            while (low <= height) {
                int mid = (height - low) / 2 + low;
                if (numbers[mid] == numbers[i] - target) {
                    return new int[]{mid + 1, i + 1};
                } else if (numbers[mid] > numbers[i] - target) {
                    height = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 解法3:快慢指针
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int[] twoSumSolution3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
