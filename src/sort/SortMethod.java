package sort;

/**
 * Author:  andy.xwt
 * Date:    2018/4/26 23:14
 * Description:排序算法
 */

public class SortMethod {

    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 5, 1};
        choseSort(a);
        printArray(a);
    }

    /**
     * 冒泡排序，找最大的，一个比较，
     */
    public static void bubbleSort(int array[]) {
        for (int i = array.length - 1; i > 1; i--) {//判断取值范围。0 到 a.length-1
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, i, j);
                }
            }
        }
    }


    /**
     * 选择排序 最小的放在最右边
     */
    public static void choseSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    swap(array, j, i);
                }
            }
        }
    }

    /**
     * 交换数组中的元素
     *
     * @param array   数组
     * @param change  交换角标
     * @param changed 被交换角标
     */
    private static void swap(int[] array, int change, int changed) {
        int temp = array[changed];
        array[changed] = array[change];
        array[change] = temp;
    }

    /**
     * 打印数组排序后的内容
     */
    private static void printArray(int array[]) {
        StringBuffer sb = new StringBuffer();
        for (int i : array) {
            sb.append("[" + i + "]->");
        }
        System.out.println(sb.toString());
    }


}
