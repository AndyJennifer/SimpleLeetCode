package simple.array;

import utils.ArrayUtils;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 20:27
 * Description:
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */

public class SortedSquares {

    /**
     * 解题思路：
     * 建立双指针，也就是控制角标
     */
    public static void main(String[] args) {
        int[] arr = sortedSquares(new int[]{4, -1, 0, 3, 10});
        ArrayUtils.printArray(arr);
    }

    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] array = new int[n];
        int l = 0, r = n - 1, newLength = n - 1;
        while (newLength >= 0) {//小于0表示数组已经填充完毕了，所以跳出循环
            int a = A[l] * A[l];
            int b = A[r] * A[r];
            //左边大则左边移动
            l = a >= b ? l + 1 : l;
            //右边大则右边移动
            r = b > a ? r - 1 : r;
            array[newLength--] = Math.max(a, b);
        }
        return array;
    }
}
