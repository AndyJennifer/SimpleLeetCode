package practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:  andy.xwt
 * Date:    2020/11/12 14:19
 * Description:
 * 509-斐波那契数{@link simple.math.Fib}
 * 905-按奇偶排序数组{@link simple.array.SortArrayByParity}
 * 977-有序数组的平方{@link simple.array.SortedSquares}
 */


class Day10 {

    ///////////////////////////////////////////////////////////////////////////
    // 斐波那契数
    ///////////////////////////////////////////////////////////////////////////

    public int fibSolution1(int n) {
        if (1 <= n) {
            return n;
        }
        return fibSolution1(n - 1) + fibSolution2(n - 2);
    }

    public int fibSolution2(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    public int helper(int[] memo, int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 解法3：备忘录模式，自顶向上
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int fibSolution3(int n) {
        if (n <= 1) {
            return n;
        }
        //dp数组
        int[] dp = new int[n + 1];

        //baseCase
        dp[0] = 0;
        dp[1] = 1;

        //状态转移方程
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int fibSolution4(int n) {
        if (n <= 1) {
            return n;
        }
        int result = 0;
        int pre1 = 0;
        int pre2 = 1;

        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 按奇偶排序数组
    ///////////////////////////////////////////////////////////////////////////

    public int[] sortArrayByParitySolution1(int[] A) {

        Integer a[] = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            a[i] = A[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1 % 2, o2 % 2);
            }
        });
        for (int i = 0; i < A.length; i++) {
            A[i] = a[i];
        }
        return A;
    }


    public int[] sortArrayByParitySolution2(int[] A) {
        int a[] = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                a[t++] = A[i];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                a[t++] = A[i];
            }
        }
        return a;
    }


    public int[] sortArrayByParitySolution3(int[] A) {
        int low = 0;
        int height = A.length - 1;
        int a[] = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                a[low++] = A[i];
            } else {
                a[height--] = A[i];
            }
        }
        return a;
    }

    public int[] sortArrayByParitySolution4(int[] A) {

        int low = 0;
        int height = A.length - 1;
        while (low < height) {

            if (A[low] % 2 > A[height] % 2) {
                int temp = A[low];
                A[low] = A[height];
                A[height] = temp;
            }

            if (A[low] % 2 == 0) {
                low++;
            }
            if (A[height] % 2 == 0) {
                height--;
            }
        }
        return A;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 有序数组的平方
    ///////////////////////////////////////////////////////////////////////////

    public int[] sortedSquaresSolution1(int[] A) {
        int a[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            a[i] = A[i] * A[i];
        }
        Arrays.sort(a);
        return a;
    }


    public int[] sortedSquaresSolution2(int[] A) {
        int low = 0;
        int height = A.length - 1;
        int len = A.length - 1;
        int a[] = new int[A.length];

        while (low <= height) {
            if (A[low] * A[low] > A[height] * A[height]) {
                a[len--] = A[low] * A[low];
                low++;
            } else {
                a[len--] = A[height] * A[height];
                height--;

            }
        }
        return a;

    }

}
