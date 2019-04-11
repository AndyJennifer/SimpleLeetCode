package simple.array;

import utils.ArrayUtils;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 21:34
 * Description: 按奇偶排序数组
 * <p>
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] array = sortArrayByParity(new int[]{3, 1, 2, 4});
        ArrayUtils.printArray(array);
    }

    /**
     * 解题思路和双指针差不多
     * {@link SortedSquares}
     */
    public static int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int arr[] = new int[length];
        int l = 0, r = length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                arr[l++] = A[i];
            } else {
                arr[r--] = A[i];
            }
        }
        return arr;
    }
}
