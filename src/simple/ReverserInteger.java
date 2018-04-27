package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/4/27 19:35
 * Description:
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverserInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    /**
     * 分析：一般我们取数字的某一位都是取余数，判断某个数有几位除以10最后除数为0就知道了
     */
    private static int reverse(int x) {
        long val = 0;//用Long 是因为怕越界
        while (x != 0) {
            val = val * 10 + x % 10;//上次的余数*10+现在的余数 为颠倒后的数 使用long 就不会怕越界
            x = x / 10;//while循环能走几次，代表数有多少位。
        }
        return (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) ? 0 : (int) val;
    }
}
