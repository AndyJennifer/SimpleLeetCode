package simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  andy.xwt
 * Date:    2020/11/5 22:50
 * Description:杨辉三角2
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */


public class GenerateTriangle2 {

    /**
     * 思路：杨辉三角的每一行都是1，每一行的元素（排除头尾），都是上一行相邻那个位置的元素之后
     * 1
     * 11
     * 121
     * 1331
     */

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            //先将每行元素都设置为1
            row.set(i, 1);
            //设置中间的数据为上一行对应位置+上一行对应位置减一
            for (int j = i; j > 1; j--) {
                row.set(j - 1, row.get(j - 1) + row.get(j - 2));
            }
        }
        return row;
    }

}
