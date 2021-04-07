package practice2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Author:  andy.xwt
 * Date:    2020/12/10 18:29
 * Description:
 * 521-最长特殊序列1{@link simple.str.FindLUSLength}
 * 522-最长特殊序列2{@link simple.str.FindLUSLength2}
 * 541-反转字符串2{@link simple.str.ReverseStr}
 */


class Day21 {

    ///////////////////////////////////////////////////////////////////////////
    // 最长特殊序列1
    ///////////////////////////////////////////////////////////////////////////
    public int findLUSLengthSolution1(String a, String b) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : new String[]{a, b}) {
            for (int i = 0; i < (1 << s.length()); i++) {
                String str = "";
                for (int j = 0; j < s.length(); j++) {
                    if (((i >> j) & 1) != 0) {
                        str += s.charAt(i);
                    }
                }
                map.put(str, map.getOrDefault(str, 1) + 1);
            }
        }

        int max = -1;
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                max = Math.max(max, key.length());
            }
        }
        return max;
    }


    public int findLUSLengthSolution2(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }

    ///////////////////////////////////////////////////////////////////////////
    // 最长特殊序列2
    ///////////////////////////////////////////////////////////////////////////


    public int findLUSlengthSolution1(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            for (int i = 0; i < (1 << str.length()); i++) {
                String s = "";
                for (int j = 0; j < str.length(); j++) {
                    if (((i >> j) & 1) != 0) {
                        s += s.charAt(i);
                    }
                }

                map.put(s, map.getOrDefault(s, 1) + 1);
            }
        }
        int max = -1;
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                max = Math.max(max, s.length());
            }
        }
        return -1;
    }

    private boolean isSubSequence(String a, String b) {
        int j = 0;
        for (int i = 0; i < b.length() && j < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                j++;
            }
        }
        return j == a.length();
    }

    public int findLUSlengthSolution2(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length - 1; i++) {
            int j;
            for (j = 1; j < strs.length; j++) {
                if (!isSubSequence(strs[i], strs[j])) {
                    break;
                }
            }

            if (j == strs.length) {
                max = Math.max(strs[i].length(), max);
            }
        }
        return max;
    }


    public int findLUSlengthSolution3(String[] strs) {

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < strs.length - 1; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (!isSubSequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;

    }

    ///////////////////////////////////////////////////////////////////////////
    // 反转字符串2
    ///////////////////////////////////////////////////////////////////////////
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, s.length());
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return new String(chars);
    }
}
