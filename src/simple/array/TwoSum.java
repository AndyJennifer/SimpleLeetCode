package simple.array;

import java.util.HashMap;

import utils.ArrayUtils;

/**
 * Author:  andy.xwt
 * Date:    2020/5/26 22:46
 * Description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *  
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 */


class TwoSum {

    /**
     * 第一解决方法：暴力枚举
     * 时间复杂度为O(N^2)，空间复杂度为0(1)
     * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，
     * 因此不需要再进行匹配。而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
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
        //先将所有的元素重入map中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {//对于hashMap,最坏O(logN)
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
