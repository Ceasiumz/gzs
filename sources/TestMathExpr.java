import java.util.*;
public class TestMathExpr {
    public static String getInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static void parse_line(String s1, String s2, String s3) {
        int i1 = Integer.parseInt(s1);
        int i3 = Integer.parseInt(s3);
        try {
            switch (s2) {
                case "+":
                    System.out.println(i1 + i3);
                    break;
                case "-":
                    System.out.println(i1 - i3);
                    break;
                case "*":
                    System.out.println(i1 * i3);
                    break;
                case "/":
                    System.out.println(i1 / i3);
                    break;
                default:
                    System.out.println("Invalid operator");
            }
        } catch (ArithmeticException zmj) {
            System.out.println("Division by zero" + zmj.getMessage());
    }
    }

    public static void main(String[] args) {
        int valid_number = 1;
        boolean valid = true;
        try {
            do {
                int line_number = Integer.parseInt(getInput());
                for (int i = 0; i < line_number; i++) {
                    String s = getInput();
                    String[] t = s.split(" ");
                    TestMathExpr.parse_line(t[0], t[1], t[2]);
                }
                valid = true;
            } while (!valid);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()+"\nPlease enter again");
            valid = false;
        }
    }
}