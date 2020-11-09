package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2020/11/6 17:20
 * Description: 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class MaxProfit {

    /**
     * 解法1 :暴力枚举
     * 思路：我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
     * 形式上，对于每组i 和 j (其中 j>i)我们需要找出 max(prices[j]-prices[i])
     * <p>
     * 时间复杂度：O(N2)
     * 空间复杂度:O(1)
     */
    public int maxProfitSolution1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 0; j < prices.length; j++) {
                int dx = prices[j] - prices[i];
                if (dx > max) {
                    max = dx;
                }
            }
        }
        return max;
    }

    /**
     * 解法2：直接找到历史最低点，然后假设第i天卖出股票能得到的利润就为 prices[i]-minprice
     * <p>
     * 时间复杂度为：O(N)
     * 空间复杂度:O(1)
     */
    public int maxProfitSolution2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                //找到历史最低点
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


}
