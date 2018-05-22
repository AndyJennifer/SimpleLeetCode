package simple;

/**
 * Author:  andy.xwt
 * Date:    2018/5/3 13:44
 * Description:
 */

public class AddBinary {
    public static void main(String[] args) {
        addBinary("1010", "1011");
    }

    public static String addBinary(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        int divi = 0;
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int aCurrent = i >= 0 ? a.charAt(i) - '0' : 0;
            int bCurrent = j >= 0 ? b.charAt(j) - '0' : 0;
            int reminder = (aCurrent + bCurrent + divi) % 2;
            divi = (aCurrent + bCurrent + divi) / 2;//计算余数
            sb.append(reminder);
            i--;
            j--;
        }
        if (divi > 0) {//判断最后一位
            sb.append(divi);
        }
        return sb.reverse().toString();

    }

}
