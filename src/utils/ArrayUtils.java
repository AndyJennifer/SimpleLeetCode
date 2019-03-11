package utils;

/**
 * Author:  andy.xwt
 * Date:    2019-03-12 01:44
 * Description:
 */

public class ArrayUtils {

    /**
     * 交换数组中的数据
     */
    public static void swap(int array[], int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    /**
     * 打印数组中的数据
     */
    public static void printArray(int array[]) {
        StringBuffer sb = new StringBuffer();
        for (int i : array) {
            sb.append("[+" + i + "]->");
        }
        System.out.println(sb.toString());
    }

}
