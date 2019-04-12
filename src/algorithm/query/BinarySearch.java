package algorithm.query;

/**
 * Author:  andy.xwt
 * Date:    2018/5/22 09:49
 * Description:二分查找
 */

public class BinarySearch {

    /**
     * 二分查找
     *
     * @param array 查找的数组
     * @param size  数组的大小
     * @param value 查找的值
     */
    static int binarySearch(int[] array, int size, int value) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            //找到中间数
            final int mid = (left + right) >>> 1;
            final int midValue = array[mid];
            if (midValue < value) {//如果比中间大，那么从中间数的右面开发
                left = mid + 1;
            } else if (midValue > value) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
