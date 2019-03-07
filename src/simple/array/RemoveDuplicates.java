package simple.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 21:10
 * Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class RemoveDuplicates {

    public static void main(String[] args) {

        removeDuplicates(new int[]{1, 1, 2});

    }

    /**
     * 第一种解法就是去重
     */
    public static int removeDuplicates(int[] nums) {
        Set set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        Iterator iterator = set.iterator();
        int count = 0;
        while ((iterator.hasNext())) {
            Integer a = (Integer) iterator.next();
            nums[count] = a;
            count++;
        }
        return count;
    }

    /**
     * 第二中解法
     */
    public int removeDuplicates2(int[] nums) {
        int index = -1;
        int val = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++index] = nums[i];
                val = nums[i];
            }
        }
        return index + 1;
    }

}
