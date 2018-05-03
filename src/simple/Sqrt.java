package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/3 14:33
 * Description:
 */

public class Sqrt {
    public static void main(String[] args) {

        mySqrt(0);
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (x - (i * i) < min) {
                if (x - (i * i) >= 0) {
                    min = x - (i * i);
                    index = i;
                }
            } else {
                break;
            }
        }
        return index;
    }

}
