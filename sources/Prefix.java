import java.util.*;

class Prefix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> strings = Arrays.asList(input.nextLine().split(" "));
        input.close();
        List<Character> pre = new ArrayList<>(List.of());
        List<Character> prefix = null;
        prefix:
        for (String word : strings) {
            for (int j = 0; j < word.length(); j++) {
                if (j >= pre.size()) {
                    pre.add(word.charAt(j));
                } else if (word.charAt(j) !=
                        pre.get(j)) {
                    prefix = pre.subList(0, j);
                    break prefix;
                }
            }
        }

        if (prefix != null) {
            prefix.forEach(System.out::print);
        }
    }
}
