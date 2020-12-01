package simple.math;

/**
 * Author:  andy.xwt
 * Date:    2020/11/12 14:33
 * Description:裴波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Fib {

    /**
     * 解法1：递归
     * 1.检查整数N，如果N小于等于1，则返回N
     * 2.否则，通过递归关系Fn=Fn-1+Fn-2
     * 3.直到所有计算返回结果得到答案
     * <p>
     * 时间复杂度：O(2^N)
     * 空间复杂度：O(N)
     */
    public int fibSolution1(int N) {
        if (N <= 1) {
            return N;
        }
        return fibSolution1(N - 1) + fibSolution2(N - 2);

    }

    /**
     * 解法2：记忆化并向上递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int fibSolution2(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }
        int dp[] = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];


    }

    /**
     * 解法3：自底向上迭代与解法2的区别就是没有创建额外的数组
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int fibSolution3(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int result = 0;
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 3; i <= N; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
