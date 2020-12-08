package simple.str;

/**
 * Author:  andy.xwt
 * Date:    2018/5/3 13:44
 * Description:二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class AddBinary {

    /**
     * 解法：先将 aa 和 bb 转化成十进制数，求和后再转化为二进制数
     */
    public String addBinarySolution1(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    /**
     * 解法2：思路和链表的两数之后非常像{@link simple.link.AddTwoNumbers}
     */
    public String addBinarySolution2(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = n1 + n2 + carry;

            carry = sum / 2;//计算进位

            sb.append(sum % 2);//计算余数
            i--;
            j--;
        }
        if (carry > 0) {//判断最后一位
            sb.append(carry);
        }
        return sb.reverse().toString();

    }


}
