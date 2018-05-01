package simple;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:  andy.xwt
 * Date:    2018/5/1 21:10
 * Description:
 */

public class RemoveDuplicates {

    public static void main(String[] args) {

        removeDuplicates(new int[]{1, 1, 2});

    }

    public static int removeDuplicates(int[] nums) {
        Set set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        Iterator iterator = set.iterator();
        int count = 0;
        while ((iterator.hasNext())) {
            Integer a = (Integer) iterator.next();
            nums[count] = a;
            count++;
        }
        return count;

    }


}
