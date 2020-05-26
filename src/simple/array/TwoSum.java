package simple.array;

import java.util.HashMap;

import utils.ArrayUtils;

/**
 * Author:  andy.xwt
 * Date:    2020/5/26 22:46
 * Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 */


class TwoSum {

    /**
     * 第一解决方法的时间复杂度为O(N^2)，空间复杂度为0(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }

    /**
     * 第二种解法：时间复杂度为O(N)+O(logN) = O(N)(取最大），空间复杂度为0(N)（因为要创建一个HashMap来存储数组）
     * <p>
     * 这里其实可以考虑ArrayMap(在少量数据时，效率要比HashMap快一点），减少了扩容时创建的Entry,与重新hash的计算
     */
    public static int[] twoSumSolution2(int[] nums, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {//对于hashMap,最坏O(logN),最坏
                a[0] = i;
                a[1] = map.get(b);
            }
        }
        return a;
    }

    /**
     * 第二种解法：时间复杂度为O(N)+O(logN) = O(N)(取最大），空间复杂度为0(N)
     * 但是相比第一种解法，存储的数据要更少，因为找到元素后就不存了。少存了一部分。
     */
    public static int[] twoSumSolution3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {//对于hashMap,最坏O(logN),最坏
                return new int[]{i, map.get(b)};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("not have");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 7, 15};
        int[] ints = twoSum(nums, 9);
        ArrayUtils.printArray(ints);
    }
}
