package medium.array;

/**
 * Author:  andy.xwt
 * Date:    2020/11/4 13:44
 * Description: 移除排序数组中的重复项2
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class RemoveDuplicates2 {

    /**
     * 解法1：
     * <p>
     * 思路：在原地修改数组，而最简单的方法就是删除多余的重复项。
     * 对于数组中的每个数字，若出现 2 个以上的重复项，就将多余的重复项从数组列表中删除。
     * 时间复杂度：O(N2)
     * 空间复杂度:0(1)
     */
    public static int removeDuplicatesSolution1(int[] nums) {
        int i = 1;
        int count = 1;
        int length = nums.length;

        while (i < length) {
            //判断当前位置与上一个位置是否相等
            if (nums[i] == nums[i - 1]) {
                count++;

                //当超过3个的时候，交换数组中的元素，整体移动
                if (count > 2) {
                    swap(nums, i);
                    //这里进行减减，是为了让当前角标指向最新的元素，因为在下面的代码中会进行i++操作
                    i--;

                    //因为移除了重复项，所以要对长度减1
                    length--;
                }
            } else {
                count = 1;
            }

            i++;

        }
        return length;
    }

    /**
     * 解法2：(快慢指针）
     * 思路：我们使用了两个指针，i 是遍历指针，指向当前遍历的元素；j 指向下一个要覆盖元素的位置。
     * 同样，我们用 count 记录当前数字出现的次数。count 的最小计数始终为 1。
     * 我们从索引 1 开始一次处理一个数组元素。
     * 若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。在这种情况下，我们只向前移动 i，而 j 不动。
     * 若 count <=2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
     * 若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
     * 当数组遍历完成，则返回 j。
     *
     * 时间复杂度：O(N)
     */
    public static int removeDuplicatesSolution2(int[] nums) {
        int j = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            //判断前后两数是否相等
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    private static void swap(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
    }

    public static void main(String[] args) {
        removeDuplicatesSolution2(new int[]{2, 2, 2, 3});
    }


}
