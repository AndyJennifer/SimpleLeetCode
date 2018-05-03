package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/3 16:52
 * Description:爬楼梯
 */

public class ClimbStairs {
    public static void main(String[] args) {
        climbStairs(3);
    }

    public static int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }
}
