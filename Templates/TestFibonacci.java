import java.util.*;
public class TestFibonacci {
    static Scanner input = new Scanner(System.in);

    // Here is the function you need to implement
    public static void parse_line(int n, int d) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        for(int i = 1; i < d+1; i++) {
            System.out.print(arr[n-i] + ", ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws Exception {
        int line_number = Integer.parseInt(input.nextLine());
        for (int i = 0; i < line_number; i++) {
            String s = input.nextLine();
            String[] t = s.split(", ");
            int n = Integer.parseInt(t[0]);
            int d = Integer.parseInt(t[1]);
            TestFibonacci.parse_line(n, d);
        }
    }
}
