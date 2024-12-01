import java.util.*;
public class Prime {
    static Scanner input = new Scanner(System.in);

    // Here is the function you need to implement
    public static int count(boolean[] x) {
        int counter = 0;
        for(boolean i:x){
            if (i){
                counter++;
            }
        }
        return counter-1;
    }

    public static void main(String[] args){
        double n = Double.parseDouble(input.nextLine());
        boolean[] prime = new boolean[(int)n];
        Arrays.fill(prime, true);
        for(int i = 2; i <= n; i++) {
            double gi = Math.sqrt(i);
            for(int j = 2; j <= gi; j++) {
                if(i % j == 0) {
                    prime[i-1] = false;
                    break;
                }
            }
        }
        System.out.println(count(prime));
    }
}