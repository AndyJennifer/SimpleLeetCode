package medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2018/5/22 00:08
 * Description:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -1});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        } else {
            int i = 0;
            while (i <= nums.length - 3) {
                for (int k = 1; k <= nums.length - 2; k++) {
                    if (nums[i] + nums[k] + nums[k + 1] == 0) {
                        List<Integer> add = new ArrayList<>();
                        add.add(nums[i]);
                        add.add(nums[k]);
                        add.add(nums[k + 1]);
                        list.add(add);
                    }
                }
                i++;
            }

        }

        return list;

    }
}
