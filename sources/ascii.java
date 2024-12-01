import java.util.*;
public class ascii {
    static Scanner input = new Scanner(System.in);

    public static HashMap<Integer, Character> hash = new HashMap<>();//hashmap for the words

    private char[][] blockinput() {
        char[][] line = new char[81][100];
        for(char[] x:line)
            Arrays.fill(x, ' ');
        for (int i = 0; i < 81; i++) {
            if(input.hasNextLine())
                line[i] = input.nextLine().toCharArray();
            else break;
        }
        return line;
    }//input block of words

    public static void hashmapini() {
        String word = """
                   ###  \s
                  ## ##  \s
                 ##   ## \s
                ##     ##\s
                #########\s
                ##     ##\s
                ##     ##\s
                
                ######## \s
                ##     ##\s
                ##     ##\s
                ######## \s
                ##     ##\s
                ##     ##\s
                ######## \s
                
                 ###### \s
                ##    ##\s
                ##      \s
                ##      \s
                ##      \s
                ##    ##\s
                 ###### \s
                
                ######## \s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ######## \s
                
                ########\s
                ##      \s
                ##      \s
                ######  \s
                ##      \s
                ##      \s
                ########\s
                
                ########\s
                ##      \s
                ##      \s
                ######  \s
                ##      \s
                ##      \s
                ##      \s
                
                 ######  \s
                ##    ## \s
                ##       \s
                ##   ####\s
                ##    ## \s
                ##    ## \s
                 ######  \s
                
                ##     ##\s
                ##     ##\s
                ##     ##\s
                #########\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                
                ####\s
                 ## \s
                 ## \s
                 ## \s
                 ## \s
                 ## \s
                ####\s
                
                      ##\s
                      ##\s
                      ##\s
                      ##\s
                ##    ##\s
                ##    ##\s
                 ###### \s
                
                ##    ##\s
                ##   ## \s
                ##  ##  \s
                #####   \s
                ##  ##  \s
                ##   ## \s
                ##    ##\s
                
                ##      \s
                ##      \s
                ##      \s
                ##      \s
                ##      \s
                ##      \s
                ########\s
                
                ##     ##\s
                ###   ###\s
                #### ####\s
                ## ### ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                
                ##    ##\s
                ###   ##\s
                ####  ##\s
                ## ## ##\s
                ##  ####\s
                ##   ###\s
                ##    ##\s
                
                 ####### \s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                 ####### \s
                
                ######## \s
                ##     ##\s
                ##     ##\s
                ######## \s
                ##       \s
                ##       \s
                ##       \s
                
                 ####### \s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##  ## ##\s
                ##    ## \s
                 ##### ##\s
                
                ######## \s
                ##     ##\s
                ##     ##\s
                ######## \s
                ##   ##  \s
                ##    ## \s
                ##     ##\s
                
                 ###### \s
                ##    ##\s
                ##      \s
                 ###### \s
                      ##\s
                ##    ##\s
                 ###### \s
                
                ########\s
                   ##   \s
                   ##   \s
                   ##   \s
                   ##   \s
                   ##   \s
                   ##   \s
                
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                 ####### \s
                
                ##     ##\s
                ##     ##\s
                ##     ##\s
                ##     ##\s
                 ##   ## \s
                  ## ##  \s
                   ###   \s
                
                ##      ##\s
                ##  ##  ##\s
                ##  ##  ##\s
                ##  ##  ##\s
                ##  ##  ##\s
                ##  ##  ##\s
                 ###  ### \s
                
                ##     ##\s
                 ##   ## \s
                  ## ##  \s
                   ###   \s
                  ## ##  \s
                 ##   ## \s
                ##     ##\s
                
                ##    ##\s
                 ##  ## \s
                  ####  \s
                   ##   \s
                   ##   \s
                   ##   \s
                   ##   \s
                
                ########\s
                     ## \s
                    ##  \s
                   ##   \s
                  ##    \s
                 ##     \s
                ########\s
                """;
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] wordline = word.split("\n");
        int node0 = 0;
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < wordline[8*k].length(); i++) {
                for (int j = 0; j < 7; j++) {
                    node0 = (node0)%1145 << 1;
                    node0 += (wordline[k * 8 + j].charAt(i) == '#') ? 1 : 0;
                }
            }
            hash.put(node0, letter.charAt(k));
            node0 = 0;
        }
    }//initialize the hash table

    private static int fina(int f) {
        final int ff = f;
        return ff;
    }

    int fff = fina(1145);

    public void hashrecognize(char[][] block, int n) {
        int node = 0;
        int lastnode ;
        boolean Atbound = false;
        char print = ' ';
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < 81; i++) {
                lastnode = node;
                for (int j = 0; j < 7; j++) {
                    node = node%1145 << 1;
                    if (block[k * 8 + j].length > i) {
                        node += (block[k * 8 + j][i] == ('#')) ? 1 : 0;
                    } else Atbound = true;
                }
                if (hash.containsKey(node)) {
                    print = hash.get(node);
                }//recognize a letter of a word
                if (node != 0) {
                    if (print != ' ') {
                        System.out.print(print);
                        node = 0;
                        print = ' ';
                    }
                }//check if the letter is finished
                if(Atbound){
                    System.out.print("\n");
                    Atbound = false;
                    break;
                }//check if the word is finished
                if(lastnode == node && node != 0) break;
            }//recognize a line of a word
        }
    }//recognize the block

    public static void main(String[] args) {
    ascii a = new ascii();
    hashmapini();//initialize the hash table
    String nn = input.nextLine();
    int n=Integer.parseInt(nn);//to get the number of words
    input.nextLine();//to skip the empty line
    a.hashrecognize(a.blockinput(), n);//recognize the words
    }
}