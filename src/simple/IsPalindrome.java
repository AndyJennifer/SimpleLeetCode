package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/4/28 01:31
 * Description:回文数判断
 */

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * 分析：先将数颠倒，负数直接不是
     * 如果负数数超过范围，还要进行判断。
     */
    public static boolean isPalindrome(int x) {
        int temp = x > 0 ? x : -x;
        long val = 0;
        while (x != 0) {
            val = val * 10 + x % 10;
            x = x / 10;//计算每一位的余数。
        }
        return temp == (val > Integer.MAX_VALUE ? 0 : (int) val);
    }

}
