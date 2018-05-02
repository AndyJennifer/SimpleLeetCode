package medium;

/**
 * Author:  andy.xwt
 * Date:    2018/1/23 23:23
 * Description:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {


    }

    /**
     * 分析：首先中位数是算法，则当N为奇数时，中位数角标为n+1/2；当N为偶数时中位数是 n/2 与 (n/2)+1的和的一半
     * 分析：算法复杂度有那么小，所以不能走任何排序
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }
}
