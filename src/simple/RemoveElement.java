package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 21:56
 * Description:
 */

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        removeElement(nums, 2);
    }

    public static int removeElement(int[] nums, int val) {
        //
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
