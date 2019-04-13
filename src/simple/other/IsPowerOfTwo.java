package simple.other;

/**
 * Author:  andy.xwt
 * Date:    2019-04-13 23:42
 * Description:2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 */

public class IsPowerOfTwo {

    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(0);
        System.out.println(powerOfTwo);
    }

    /**
     * 解题思路:
     * 注意：排除负数
     * 根据当前数的二进制为进行判断，如果是2的倍数那么n&(n-1)一定为0
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
