package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2020/11/4 23:19
 * Description:
 * 88-合并两个排序数组{@link simple.array.MergeArray}
 * 118-杨辉三角 {@link simple.math.GenerateTriangle}
 * 119-杨辉三角2{@link simple.math.GenerateTriangle2}
 */


class Day6 {

    ///////////////////////////////////////////////////////////////////////////
    // 合并两个排序数组
    ///////////////////////////////////////////////////////////////////////////
    public void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 杨辉三角
    ///////////////////////////////////////////////////////////////////////////
    public List<List<Integer>> generateSolution1(int numRows) {

        List<List<Integer>> rows = new ArrayList<>();
        rows.add(new ArrayList<>());
        rows.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = rows.get(i - 1);

            //设置头为1
            row.add(1);

            //设置中间的数据
            for (int j = 1; j < numRows; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            //设置尾
            row.add(1);
            rows.add(row);
        }

        return rows;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 杨辉三角2
    ///////////////////////////////////////////////////////////////////////////
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            //设置所有行中的元素为1
            rows.add(1);
            for (int j = i; j > 1; j--) {
                rows.set(j - 1, rows.get(j - 1) + rows.get(j - 2));
            }
        }

        return rows;

    }
}
