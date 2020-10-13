package simple.math;

/**
 * Author:  andy.xwt
 * Date:    2018/4/28 01:31
 * Description:回文数判断
 */

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(solution1(-121));
    }

    /**
     * 方法一：反转一半数字
     * 思路：
     * 映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。
     * 但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。
     * 第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
     * 但是，如果反转后的数字大于int.MAX我们将遇到整数溢出问题。
     * 按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     * 例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
     * <p>
     * 算法:
     * 首先，我们应该处理一些临界情况。所有负数都不可能是回文，例如：-123 不是回文，因为 - 不等于 3。所以我们可以对所有负数返回 false。
     * 除了 0 以外，所有个位是 0 的数字不可能是回文，因为最高位不等于 0。所以我们可以对所有大于 0 且个位是 0 的数字返回 false。
     * 现在，让我们来考虑如何反转后半部分的数字。
     * 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，
     * 我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。
     * 如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
     * 现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
     * 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
     */
    public static boolean solution1(int x) {
        //当 x 为负数时，x 不是回文数，如果数字的最后一位是0，并且x 不是0，那么肯定不是回文数
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        //循环一半，建立反转一半的数字
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        //针对奇数位和偶数为的数字分别判断是否为回文
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 方法2，将整数转换为字符串，然后判断字符串是否是回文，就行了
     */
    public static boolean solution2(int x) {
        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
