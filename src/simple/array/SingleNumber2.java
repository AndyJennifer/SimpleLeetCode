package simple.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2019-04-13 00:02
 * Description:只出现一次的数字2
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber2 {

    /**
     * 解法：数学算法
     * 思路：将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int singleNumberSolution1(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for (int num : nums) {
            sumArray += num;
            set.add((long) num);
        }
        for (Long s : set) {
            sumSet += s;
        }
        return (int) ((3 * sumSet - sumArray) / 2);
    }

    /**
     * 解法：HashMap
     * 思路：遍历输入数组，统计每个数字出现的次数，最后返回出现次数为 1 的数字。
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public int singleNumberSolution2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    /**
     * 解法：出现三次的数字，各 二进制位 出现的次数都是 33 的倍数。
     * 思路：因此，统计所有数字的各二进制位中 11 的出现次数，并对 33 求余，结果则为只出现一次的数字。
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public int singleNumberSolution3(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            //统计所有int数组中int 中 每一个bit位之和
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] >> i & 1) == 1) {
                    count++;
                }
            }
            //判断1的个数是否是3的倍数
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
