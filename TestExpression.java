import java.util.Stack;
public class TestExpression {

    public static int testEquilibre(String expression) {
        Stack<Character> stack = new Stack<>();
        String DelimiteursOuvrants = "({[";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (DelimiteursOuvrants.indexOf(ch) != -1) {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || !Correspondance(stack.pop(), ch)) {
                    return i+1;
                }
            }
        }

        return stack.isEmpty() ? -1 : expression.length();
    }

    public static boolean Correspondance(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }
    public static void main(String[] args) {
        String expression1 = "{[()]()}";
        String expression2 = "{[)(]}";

        System.out.println("Expression 1: " + expression1);
        System.out.println("Expression 2: " + expression2);

        int result1 = testEquilibre(expression1);
        if (result1 == -1) {
            System.out.println("L'expression 1 est équilibrée.");
        } else {
            System.out.println("L'expression 1 n'est pas équilibrée. Position du premier délimiteur incorrect : " + result1);
        }

        int result2 = testEquilibre(expression2);
        if (result2 == -1) {
            System.out.println("L'expression 2 est équilibrée.");
        } else {
            System.out.println("L'expression 2 n'est pas équilibrée. Position du premier délimiteur incorrect : " + result2);
        }
    }
    }
