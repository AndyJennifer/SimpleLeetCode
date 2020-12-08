package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2020/12/7 10:18
 * Description:字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class AddStrings {

    /**
     * 解法：竖式相加
     * 时间复杂度：O(max(len1,len2))
     * 空间复杂度:O(1)
     */
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n1 >= 0 || n2 >= 0) {
            int x = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num1.charAt(n2) - '0' : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            n1--;
            n2++;
        }

        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
