package simple.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2019-03-07 23:37
 * Description:存在重复元素2
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ContainDuplicate2 {

    /**
     * 解法1：
     * 思路：将每个元素与它之前的 k 个元素中比较查看它们是否相等。
     * 时间复杂度：O(n(min(k,n))
     * 空间复杂度：O(1)
     */
    public boolean containNearByDuplicateSolution1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    /**
     * 解法2：
     * 思路：
     * 遍历数组，对于每个元素做以下操作：
     * 1.在散列表中搜索当前元素，如果找到了就返回 true。
     * 2.在散列表中插入当前元素。
     * 3.如果当前散列表的大小超过了k， 删除散列表中最旧的元素。
     * 时间复杂度：O(n)
     * 空间复杂度 O(min(k,n))
     */
    public boolean containNearByDuplicateSolution2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
