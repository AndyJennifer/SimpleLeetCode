package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2018/1/16 22:09
 * Description:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(solution2("vjovnhuuxtdalgjccpruzqkysmwrecsalhvaqsvnlynygybinufpnpnfejyinskybgzrywelutkctnkjhryujnbpwbxl"));
    }

    /**
     * 第一次方法走的比较耗费时间 内存换时间，时间换内存
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                //判断是否sub中的数据时候重复
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < sub.length(); k++) {
                    char c = sub.charAt(k);
                    if (!set.contains(c)) {
                        set.add(c);
                    } else {
                        break;
                    }
                }
                max = Math.max(max, set.size());
            }

        }
        return max;
    }

    /**
     * 第二种解决方法 aba 移除a 剩下ba 则最大长度为ba 2
     */
    public static int solution2(String s) {
        int length = s.length();
        int i = 0, j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }


}
