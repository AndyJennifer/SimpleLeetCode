package practice2;

/**
 * Author:  andy.xwt
 * Date:    2020/12/7 10:12
 * Description:
 * 415-字符串相加{@link simple.str.AddStrings}
 * 434-字符串中的单词数{@link simple.str.CountSegments}
 * 459-重复的子字符串{@link simple.str.RepeatedSubstringPattern}
 */


class Day20 {

    ///////////////////////////////////////////////////////////////////////////
    // 字符串相加
    ///////////////////////////////////////////////////////////////////////////

    public String addStrings(String num1, String num2) {
        int x = num1.length() - 1;
        int y = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (x >= 0 || y >= 0) {

            int n1 = x >= 0 ? num1.charAt(x) - '0' : 0;
            int n2 = x >= 0 ? num2.charAt(y) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);

            x--;
            y--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    ///////////////////////////////////////////////////////////////////////////
    // 字符串中的单词数
    ///////////////////////////////////////////////////////////////////////////
    public int countSegmentsSolution1(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        String[] split = s.split("\\s+");
        return split.length;
    }


    public int countSegmentsSolution2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 重复的子字符串
    ///////////////////////////////////////////////////////////////////////////

    public boolean repeatedSubstringPatternSolution1(String s) {
        int n = s.length() - 1;
        for (int i = 1; i * 2 <= n; i++) {
            boolean isMatch = true;
            if (n % i == 0) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i) != s.charAt(j - i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPatternSolution2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
