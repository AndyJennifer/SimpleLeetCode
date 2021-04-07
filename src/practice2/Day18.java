package practice2;

/**
 * Author:  andy.xwt
 * Date:    2020/12/2 18:03
 * Description:
 * 58-最后一个单词的长度{@link simple.str.LengthOfLastWord}
 * 67-二进制求和{@link simple.str.AddBinary}
 * 125-验证回文串{@link simple.str.IsPalindrome}
 */


class Day18 {

    ///////////////////////////////////////////////////////////////////////////
    // 最后一个单词的长度
    ///////////////////////////////////////////////////////////////////////////
    public int lengthOfLastWordSolution1(String s) {

        if (s.trim().isEmpty()) {
            return 0;
        }
        String[] split = s.split(" ");
        return split[split.length - 1].length();


    }

    public int lengthOfLastWordSolution2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (count > 0) {
                    break;
                }
                continue;
            }

            count++;
        }
        return count;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 二进制求和
    ///////////////////////////////////////////////////////////////////////////

    public String addBinarySolution1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinarySolution2(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = a.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;

            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    ///////////////////////////////////////////////////////////////////////////
    // 验证回文串
    ///////////////////////////////////////////////////////////////////////////

    public boolean isPalindromeSolution1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb);
        return sb2.reverse().toString().equals(sb.toString());
    }

    public boolean isPalindromeSolution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeSolution3(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;

    }
}
