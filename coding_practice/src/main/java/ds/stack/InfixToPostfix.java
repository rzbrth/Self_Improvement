package ds.stack;

import java.util.Stack;

/*
  Step 1 : Scan the Infix Expression from left to right.
  Case : ( -> Push to stack
  Case : Operand -> print It
  Case : ) -> Keep popping from stack and print till ( is found
  Case : Operator -> If stack is empty then push
                       else:
                            Compare with the top operator in the stack (If '(' then push))
                                -> If higher precedence then push
                                -> Else: keep popping from stack and print
                                        till lower precedence operator is found
 Step 1 : Once the expression is finished then keep popping from stack and print it.

 If two operator found with same precedence then consider the previous operator as of higher and pop it out
 */
public class InfixToPostfix {

    static int checkPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result.append(c);

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                // If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }

                stack.pop(); // pop '('
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && checkPrecedence(c) <= checkPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}


