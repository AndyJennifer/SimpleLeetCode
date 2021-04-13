package medium.math;

import java.util.Arrays;

/**
 * Author:  andy.xwt
 * Date:    2021/4/12 23:16
 * Description:322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CoinChange {

    /**
     * 解法1：暴力递归，自顶向下
     * <p>
     * 状态：目标金额amount
     * 选择：coin数组中列的所有的硬币面额
     * 函数的定义or dp数组的定义：凑出金额amount 至少需要 coinChange(coins,amount)枚金币
     * base case : amount = 0 时为0，amount <0 时为-1
     */
    public int solution1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题
            int subResult = solution1(coins, amount - coin);
            //如果子问题无解，那么就跳过
            if (subResult == -1) {
                continue;
            }
            //在子问题中选择最优解，然后加一
            result = Math.min(result, subResult + 1);
        }
        //判断特殊情况
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 解法2：备忘录模，自顶向下
     */
    public int solution2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        //memo 数组全部都初始化为特殊值
        Arrays.fill(memo, -2);
        return helper(memo, coins, amount);
    }


    public int helper(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        //查备忘录，防止重复计算
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题
            int subResult = helper(memo, coins, amount - coin);
            //如果子问题无解，那么就跳过
            if (subResult == -1) {
                continue;
            }
            //在子问题中选择最优解，然后加一
            result = Math.min(result, subResult + 1);
        }
        memo[amount] = (result == Integer.MAX_VALUE) ? -1 : result;
        return memo[amount];
    }


    /**
     * 解法3：动态规划，自顶向上
     */
    public static int solution3(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);

        //base case
        dp[0] = 0;

        //外层for循环在遍历素有状态的所有取值
        for (int i = 0; i < dp.length; i++) {

            //内层for循环在求所有选择的最小值
            for (int coin : coins) {
                //子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                //选择
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int result = solution3(new int[]{1, 2, 5}, 11);
        System.out.println(result);
    }

}
