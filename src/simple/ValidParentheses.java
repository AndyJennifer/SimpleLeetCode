package simple;

import java.util.Stack;

/**
 * Author:  andy.xwt
 * Date:    2018/4/30 11:13
 * Description:
 */

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static  boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
