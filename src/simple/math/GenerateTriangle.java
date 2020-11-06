package simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2020/11/5 22:50
 * Description:杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */


public class GenerateTriangle {

    /**
     * 思路：杨辉三角的每一行都是1，每一行的元素（排除头尾），都是上一行相邻那个位置的元素之后
     */
    public static List<List<Integer>> generateSolution1(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        //添加第一行的元素
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        //添加第二行及以后的元素
        for (int i = 1; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            List<Integer> preRows = triangle.get(i - 1);

            //头是1
            rows.add(1);

            //设置中间的数据，中间的数据总是从行的角标1位置开始的
            for (int j = 1; j < i; j++) {
                rows.add(preRows.get(j - 1) + preRows.get(j));
            }
            //尾是1
            rows.add(1);
            triangle.add(rows);
        }

        return triangle;
    }

}
