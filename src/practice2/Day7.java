package practice2;

/**
 * Author:  andy.xwt
 * Date:    2020/11/6 17:21
 * Description:
 * 121-买股票的最佳时机{@link simple.array.MaxProfit}
 * 122-买股票的最佳时机2{@link simple.array.MaxProfit2}
 * 167-两数之和2-输入有序数组{@link simple.array.TwoSum2}
 */


class Day7 {

    ///////////////////////////////////////////////////////////////////////////
    // 买股票的最佳时机
    ///////////////////////////////////////////////////////////////////////////

    public int maxProfitSolution1(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > ans) {
                ans = prices[i] - min;
            }
        }
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 买股票的最佳时机2
    ///////////////////////////////////////////////////////////////////////////
    public int maxProfit2Solution1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 0; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit2Solution2(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
    ///////////////////////////////////////////////////////////////////////////
    // 两数之和2-输入有序数组
    ///////////////////////////////////////////////////////////////////////////

    public int[] twoSumSolution1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int height = numbers.length - 1;
            while (low <= height) {
                int mid = (height - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{mid + 1, i + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    height = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumSolution2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                right++;
            }
        }
        return new int[]{-1, -1};
    }
}
