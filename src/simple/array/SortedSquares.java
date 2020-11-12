package simple.array;

import java.util.Arrays;

/**
 * Author:  andy.xwt
 * Date:    2019-04-11 20:27
 * Description: 有序数组的平方
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
     * 解法1：直接暴力法
     * 思路：平方后直接排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度:O(1)
     */
    public int[] sortedSquaresSolution1(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;


    }

    /**
     * 解题思路：
     * 方法一没有利用「数组已经按照升序排序」这个条件。显然，如果数组中的所有数都是非负数，
     * 那么将每个数平方后，数组仍然保持升序；如果数组中的所有数都是负数，那么将每个数平方后，数组会保持降序。
     * 这样一来，如果我们能够找到数组A 中负数与非负数的分界线，那么就可以用类似「归并排序」的方法了。具体地，我们设
     * neg为数组A 中负数与非负数的分界线，也就是说A[0]到A[neg] 均为负数，而A[neg+1]到A[n-1]均为非负数，当我们将数组
     * A 中的数平方后，A[0]到A[neg] 单调递减，A[neg+1]到A[n-1] 单调递增。
     * <p>
     * 由于我们得到了两个已经有序的子数组，因此就可以使用归并的方法进行排序了。具体地，使用两个指针分别指向位置
     * neg 和 neg+1，每次比较两个指针对应的数，选择较小的那个放入答案并移动指针。当某一指针移至边界时，将另一指针还未遍历到的数依次放入答案。
     * 时间复杂度：O(N)
     * 空间复杂度:O(N)
     */
    public int[] sortedSquaresSolution2(int[] A) {

        int n = A.length;
        //去找负数的结束位置
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                //全是正数的情况下
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                //正数填完了，那么接着填剩下的负数
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }


    /**
     * 解法3：双指针
     * 时间复杂度：O(N)
     * 空间复杂度:O(N)
     */
    public int[] sortedSquaresSolution3(int[] A) {
        int a[] = new int[A.length];
        int low = 0;
        int height = A.length - 1;
        int len = A.length - 1;
        while (low <= height) {
            if (A[low] * A[low] > A[height] * A[height]) {
                a[len] = A[low] * A[low];
                low++;
            } else {
                a[len] = A[height] * A[height];
                height--;
            }
            len--;
        }
        return a;
    }

}
