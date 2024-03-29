package algorithm.sort;


import utils.ArrayUtils;

/**
 * Author:  andy.xwt
 * Date:    2018/4/27 10:52
 * Description:
 * 在分析排序算法时，一般有几个方面来衡量：
 * <p>
 * 1.最好情况，最坏情况，平均时间复杂度
 * 2.时间复杂度的系数，常数，低阶
 * 3.比较和交换次数。
 * 4.排序算法的内存消耗。
 * 5.稳定性(如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变)
 */

public class Sort {

    public static void main(String[] args) {
        int a[] = new int[]{11, 3, 7, 1, 8};
        shellSort(a);
        ArrayUtils.printArray(a);
    }

    /**
     * 冒泡排序 最大放在右边，两两交换
     */
    public static void bubbleSort(int array[]) {
        for (int i = array.length - 1; i > 1; i--) {//外层控制最大循环次数,为n-2次
            for (int j = 0; j < i; j++) {//里层依次向右移动，依次判断是否需要对调
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序 获取最小，放在左边
     */
    public static void choseSort(int array[]) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {//外层控制最大循环次数,为n-1次
            min = array[i];
            for (int j = i + 1; j < array.length; j++) {//里层依次向左移动，获取最小的值
                if (min > array[j]) {
                    min = array[j];
                    ArrayUtils.swap(array, i, j);//进行交换值
                }
            }
        }
    }

    /**
     * 插入排序，针对有序的，获取有序的向指定位置移动
     * 插入排序的思想：
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
     */
    public static void insertSort(int array[]) {
        int in, out;
        for (out = 0; out < array.length; out++) {//外层最大循环次数为n次，
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
     * 快排
     */
    public static void quickSort() {

    }


}
