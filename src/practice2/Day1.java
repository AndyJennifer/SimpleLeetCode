package practice2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/10/10 13:29
 * Description:
 * 1-两数之和 {@link simple.array.TwoSum}
 * 2-两数相加 {@link simple.link.AddTwoNumbers}
 * 3-无重复字符的最长子串 {@link medium.str.LongestSubstring}
 */


class Day1 {

    ///////////////////////////////////////////////////////////////////////////
    // 两数之和
    ///////////////////////////////////////////////////////////////////////////

    public static int[] twoSumSolution1(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (a[i] + a[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }

    public static int[] twoSumSolution2(int[] nums, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                a[0] = i;
                a[1] = map.get(target - nums[i]);
                return a;
            }
        }
        return a;
    }

    public static int[] twoSumSolution3(int[] nums, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dx = target - nums[i];
            if (map.containsKey(dx)) {
                a[0] = map.get(dx);
                a[1] = i;
                return a;
            } else {
                map.put(nums[i], i);
            }
        }
        return a;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 两数相加
    ///////////////////////////////////////////////////////////////////////////

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int num = (a + b + carry) % 10;
            carry = (a + b) % 10;

            if (head == null) {
                head = new ListNode(num);
                tail = head;
            } else {
                tail.next = new ListNode(num);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 无重复字符的最长子串
    ///////////////////////////////////////////////////////////////////////////
    public static int LongestSubstringSolution1(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < sub.length(); k++) {
                    char c = sub.charAt(i);
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


    public static int LongestSubstringSolution2(String s) {
        int left = 0, right = 0, max = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        while (left < len && right < len) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

}
