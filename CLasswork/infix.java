import java.util.*;

class Solution {

    static int precedence(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            }

          
            else if (c == '(') {
                stack.push(c);
            }

        
            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        String exp = "A+B*C";
        System.out.println(infixToPostfix(exp));
    }
}