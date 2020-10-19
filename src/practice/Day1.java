package practice;

import java.util.HashMap;
import java.util.HashSet;

import domain.ListNode;

/**
 * Author:  andy.xwt
 * Date:    2020/10/10 13:29
 * Description:
 * 1-两数之和
 * 2-两数相加
 * 3-无重复字符的最长子串
 */


class Day1 {

    ///////////////////////////////////////////////////////////////////////////
    // 两数之和
    ///////////////////////////////////////////////////////////////////////////

    public static int[] twoSumSolution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("have no result");
    }

    public static int[] twoSumSolution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("have no result");
    }

    ///////////////////////////////////////////////////////////////////////////
    // 两数相加
    ///////////////////////////////////////////////////////////////////////////

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
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
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String result = s.substring(i, j);
                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < result.length(); k++) {
                    if (!set.contains(result.charAt(k))) {
                        set.add(result.charAt(k));
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
        int left = 0, right = 0;
        int max = 0;
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        while (left < length && right < length) {
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
