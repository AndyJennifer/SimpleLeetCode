package simple.array;

/**
 * Author:  andy.xwt
 * Date:    2018/5/3 00:12
 * Description: 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{5, 8, 7, 8, 9});
    }

    public static int[] plusOne(int[] digits) {

        //从最后一位开始，加1，如果等于0表示要进位
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            //判断是否需要进行进位
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        //处理特殊的情况比如全是999这种
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


}
