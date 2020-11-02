package simple.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 21:10
 * Description:删除排序数组中的重复项
 * <p>
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

        int i = removeDuplicates3(new int[]{0, 1, 2});
        System.out.println(i);

    }

    /**
     * 第一种解法就是去重,时间复杂度O(logN)，空间复杂度O(N),不满足空间复杂度为0(1)
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
     * 第二中解法双指针（快慢指针）:
     * <p>
     * 首先注意数组是有序的，那么重复的元素一定会相邻。
     * <p>
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     * <p>
     * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
     * <p>
     * 1.比较 p 和 q 位置的元素是否相等。
     * <p>
     * 如果相等，q 后移 1 位
     * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
     * 重复上述过程，直到 q 等于数组长度。
     * <p>
     * 返回 p + 1，即为新数组长度。
     * <p>
     * 时间复杂度为0(N),空间复杂度为0(1),
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 第三种解法，逻辑上更清楚
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];//如果数组都是不相同的，nums = [0,1,2],那么就会原地覆盖一次
            }
            j++;
        }
        return i + 1;
    }
}
