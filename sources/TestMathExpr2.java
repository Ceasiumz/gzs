import java.util.Scanner;
import java.util.Stack;

public class TestMathExpr2 {
    static int cache;

    public static double parse(String expr, int... mode) {
        boolean _special = mode.length > 0 && mode[0] == 1;
        // 1 -> special expression
        expr = expr.replaceAll(" ", "");
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        parse:
        for (int i = 0; i < expr.length(); i++) {
            char current = expr.charAt(i);
            if (Character.isDigit(current) || current == '.') {
                StringBuilder currNum = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    currNum.append(expr.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(currNum.toString()));
            }
            // deal with braces
            else if (current == '(') {
                operators.push(current);

            } else if (current == ')') {
                while (operators.peek() != '(') {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(calculate(a, b, op));
                }
                operators.pop();
            }
            //calculate the most urgent brace
            else if (isOperator(current)) {
                if (current == '-' && i == 0) {
                    numbers.push(0.0);
                } else if (!_special) {
                    if (current == '-' && expr.charAt(i - 1) == '(') {
                        numbers.push(0.0);
                    }
                }

                while (!operators.empty() && hasPrecedence(current, operators.peek())) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(calculate(a, b, op));
                }
                operators.push(current);
            } else if (current == 's') {
                // deal with sin
                if (expr.startsWith("sin(", i)) {
                    i += 3;
                    String subExpr = expr.substring(i);
                    numbers.push(Math.sin(parse(subExpr, 1)));
                    i += cache;
                    cache = 0;
                }
            } else if (current == 'c') {
                // deal with cos
                if (expr.startsWith("cos(", i)) {
                    i += 3;
                    String subExpr = expr.substring(i);
                    numbers.push(Math.cos(parse(subExpr, 1)));
                    i += cache;
                    cache = 0;
                }
            } else if (current == 't') {
                // deal with tan
                if (expr.startsWith("tan(", i)) {
                    i += 3;
                    String subExpr = expr.substring(i);
                    numbers.push(Math.tan(parse(subExpr, 1)));
                    i += cache;
                    cache = 0;

                }

            } else if (current == 'q') {
                // deal with sqrt
                if (expr.startsWith("qrt(", i)) {
                    i += 3;
                    String subExpr = expr.substring(i);
                    numbers.push(Math.sqrt(parse(subExpr, 1)));
                    i += cache;
                    cache = 0;
                }
            }
            if (_special) {
                if (!operators.contains('(')) {
                    cache = i;
                    break;
                }
            }
        }

        while (!operators.empty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operators.pop();
            numbers.push(calculate(a, b, op));
        }

        return numbers.pop();
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    public static double calculate(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            double result = parse(input.nextLine());
            System.out.println(Math.round(result));
        }
    }
}