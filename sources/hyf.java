import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

public class hyf {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(1);
        input.push(2);
        input.push(3);
        input.push(4);
        int s2 = input.pop();
        List<Integer> list = input.stream().map(s -> s+1).toList();
    }
}