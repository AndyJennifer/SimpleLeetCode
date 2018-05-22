package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2018/5/22 00:08
 * Description:
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
