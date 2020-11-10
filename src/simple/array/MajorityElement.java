package simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2019-04-13 22:18
 * Description: 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

public class MajorityElement {

    public static void main(String[] args) {
        int result = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(result);
    }


    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i + 1];
                }
            }
        }
        return res;
    }

    /**
     * 解法1：
     * 思路：我们使用哈希映射（HashMap）来存储每个元素以及出现的次数。对于哈希映射中的每个键值对，键表示一个元素
     * ，值表示该元素出现的次数。我们用一个循环遍历数组 nums 并将数组中的每个元素加入哈希映射中。
     * 在这之后，我们遍历哈希映射中的所有键值对，返回值最大的键。
     * 我们同样也可以在遍历数组 nums 时候使用打擂台的方法，维护最大的值，这样省去了最后对哈希映射的遍历。
     * 时间复杂度：O(N)
     * 空间复杂度:0(N)
     */
    public static int majorityElementSolution1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Map.Entry<Integer, Integer> resultEntry = null;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (resultEntry == null || entry.getValue() > resultEntry.getValue()) {
                resultEntry = entry;
            }
        }
        return resultEntry.getValue();

    }

    /**
     * 解法2：
     * 思路：因为出现最多次次数的数字个数超过了一半，那么对数组进行排序，那么中间的那个数肯定是众数
     */
    public static int majorityElementSolution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
