package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/2 23:27
 * Description:最大字符长度
 */

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a     "));
    }

    public static int lengthOfLastWord(String s) {
        if (s.trim().isEmpty()) {
            return 0;
        }
        String[] split = s.split(" ");
        return split[split.length-1].length();


    }
}
