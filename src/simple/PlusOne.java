package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/3 00:12
 * Description:
 */

public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{5, 8, 7, 8, 8});
    }

    public static int[] plusOne(int[] digits) {
        int divisor = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i] + divisor;
            digits[i] = current % 10;//余数
            divisor = current / 10;//除数
        }
        if (digits[0] == 0) {//判断最高位是否是0
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;

        }
        return digits;

    }
}
