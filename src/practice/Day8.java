package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2020/11/10 10:40
 * Description:
 * 169-多数(众数）元素{@link simple.array.MajorityElement }
 * 189-旋转数组{@link  medium.array.RotateArray }
 * 217-存在重复元素{@link simple.array.ContainDuplicate }
 */


class Day8 {

    ///////////////////////////////////////////////////////////////////////////
    // 多数元素
    ///////////////////////////////////////////////////////////////////////////
    public static int majorityElementSolution1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> resultEntry = null;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (resultEntry == null || entry.getValue() > resultEntry.getValue()) {
                resultEntry = entry;
            }
        }
        return resultEntry.getValue();

    }


    public static int majorityElementSolution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    ///////////////////////////////////////////////////////////////////////////
    // 旋转数组
    ///////////////////////////////////////////////////////////////////////////

    public void rotateSolution1(int[] nums, int k) {
        //暴力法,
        int temp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    public void rotateSolution2(int[] nums, int k) {
        //取余,新增数组法
        int a[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < a.length; i++) {
            nums[i] = a[i];
        }

    }

    public void rotateSolution3(int[] nums, int k) {
        //三次旋转法
        rotateArray(nums, 0, nums.length - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, nums.length - 1);
    }

    private void rotateArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // 存在重复元素
    ///////////////////////////////////////////////////////////////////////////
    public boolean containDuplicateSolution1(int[] nums) {
        //暴力法
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containDuplicateSolution2(int[] nums) {
        //Hash表
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containDuplicateSolution3(int[] nums) {
        //排序法
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
