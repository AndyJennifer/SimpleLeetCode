package simple.array;

import java.util.Arrays;
import java.util.Comparator;

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


    /**
     * 解法1：排序算法
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度:O(N)
     */
    public int[] sortArrayByParitySolution1(int[] A) {
        Integer[] b = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            b[i] = A[i];
        }
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1 % 2, o2 % 2);
            }
        });
        for (int i = 0; i < A.length; i++) {
            A[i] = b[i];
        }
        return A;
    }

    /**
     * 解法2：两遍扫描,第一遍扫偶数，第二遍扫奇数
     * 时间复杂度：O(N)
     * 空间复杂度:O(N)
     */
    public int[] sortArrayByParitySolution2(int[] A) {
        int a[] = new int[A.length];

        int index = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                a[index++] = A[i];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                a[index++] = A[i];
            }
        }
        return a;
    }

    /**
     * 解法3：两边扫描
     * <p>
     * 算法：分别用两个指针指向奇数与偶数
     * 时间复杂度：O(N)
     * 空间复杂度:O(N)
     * <p>
     * 与这道题{@link SortedSquares}解法类似
     */
    public int[] sortArrayByParitySolution3(int[] A) {
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

    /**
     * 解法4：原地前后替换
     * 时间复杂度：O(N)
     * 空间复杂度:O(1)
     */
    public int[] sortArrayByParitySolution4(int[] A) {
        int low = 0;
        int height = A.length - 1;
        while (low < height) {
            if (A[low] % 2 > A[height] % 2) {
                //将偶数放在前面,奇数放在后面
                int temp = A[low];
                A[low] = A[height];
                A[height] = temp;
            }
            //然后移动位置
            if (A[low] % 2 == 0) {
                low++;
            }
            if (A[height] % 2 == 0) {
                height--;
            }
        }
        return A;
    }
}
