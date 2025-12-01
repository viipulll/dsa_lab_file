import java.util.Stack;

public class QUESTION6 {

    // Function to return precedence of operators
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    // Check if operator is right associative (like ^)
    public static boolean isRightAssociative(char ch) {
        return ch == '^';
    }

    // Function to convert infix to postfix
    public static String infixToPostfix(String infix) {

        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (char ch : infix.toCharArray()) {

            // If character is operand
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            }
            // If '(' push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')' pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // remove '('
            }
            // Operator encountered
            else {
                while (!stack.isEmpty() &&
                        precedence(ch) <= precedence(stack.peek()) &&
                        !isRightAssociative(ch)) {

                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    public static void main(String[] args) {

        String infix = "A*(B+C)/D";

        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
    }
}
