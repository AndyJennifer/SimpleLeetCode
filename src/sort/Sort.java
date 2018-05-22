package sort;

/**
 * Author:  andy.xwt
 * Date:    2018/4/27 10:52
 * Description:
 */

public class Sort {

    public static void main(String[] args) {
        int a[] = new int[]{11, 3, 7, 1, 8};
        shellSort(a);
        printArray(a);
    }

    /**
     * 冒泡排序 最大放在右边，两两交换
     */
    public static void bubbleSort(int array[]) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

    }

    /**
     * 选择排序 获取最小，放在左边
     */
    public static void choseSort(int array[]) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            for (int j = i + 1; j < array.length; j++) {//获取最小的值
                if (min > array[j]) {
                    min = array[j];
                    swap(array, i, j);//进行交换值
                }
            }
        }
    }

    /**
     * 插入排序，针对有序的，获取有序的向指定位置移动
     */
    public static void insertSort(int array[]) {
        int in, out;
        for (out = 0; out < array.length; out++) {
            int temp = array[out];//记录要移动的值
            in = out;
            while (in > 0 && array[in - 1] >= temp) {//如果下一个比上一个大
                array[in] = array[in - 1];//那么大的向右移动
                --in;//继续移动
            }
            array[in] = temp;//空位设置数据
        }
    }

    /**
     * 希尔排序 N LOG N 2
     */
    public static void shellSort(int array[]) {
        int inner, outer;
        int h = 1;
        while (h <= array.length / 3) {//找到最大的h
            h = h * 3 + 1;
        }
        while (h > 0) {//逐渐减少h,直至h=1;
            for (outer = h; outer < array.length; outer++) {//区间增量排序
                int temp = array[outer];
                inner = outer;
                while (inner > h - 1 && array[inner - h] > temp) {
                    array[inner] = array[inner - h];
                    inner -= h;//按照步长移动
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }

    }

    /**
     * 交换数组中的数据
     */
    private static void swap(int array[], int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    private static void printArray(int array[]) {
        StringBuffer sb = new StringBuffer();
        for (int i : array) {
            sb.append("[+" + i + "]->");
        }
        System.out.println(sb.toString());
    }


}
