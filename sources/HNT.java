import java.util.*;
public class HNT {
    public static String getInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static int[] convertarray(String[] obj){
        int[] array = Arrays.stream(obj).mapToInt(Integer::parseInt).toArray();
        return array;
    }
    static int op = 0;
    public static void counter(){
        op++;
        //System.out.print(" counter: "+op);
    }
    public static void hannuota(int n, char now, char to, char empty){
        if(n<=1){
            //System.out.print("\n" + now + "->" + to);
            counter();
        }else {
            hannuota(n - 1, now, empty, to);
            //System.out.print("\n" + now + "->" + to);
            counter();
            hannuota(n - 1, empty, to, now);
        }
    }
    static char[] bars = new char[]{'S', 'M', 'D'};
    public static void main(String[] args){
        System.out.print("the layers of the tower");
        int n=Integer.parseInt(getInput());
        System.out.print("Where to start and end");
        String putin = getInput();
        char start = putin.charAt(0);
        char end = putin.charAt(1);
        int s,e;
        s = switch (start) {
            case 'S' -> 0;
            case 'M' -> 1;
            case 'D' -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + start);
        };// resign s
        e = switch (end)   {
            case 'S' -> 0;
            case 'M' -> 1;
            case 'D' -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + start);
        };// resign e
        hannuota(n,bars[s],bars[e],bars[3-s-e]);
        System.out.print("\n"+op);
        }
}
