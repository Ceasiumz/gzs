import java.util.Arrays;
import java.util.Scanner;

public class RegionFill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RegionFill rf = new RegionFill();
        int[][] block = rf.blockParse20_20(input);
        int[] para = Arrays.stream(input.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int x = para[0];
        int y = para[1];
        rf.blockOut20_20(rf.fill(block, x, y));

    }

    int[][] blockParse20_20(Scanner input) {
        int[][] block = new int[20][20];
        for (int row = 0; row < 20; row++) {
            String line_now = input.nextLine();
            for (int column = 0; column < 20; column++) {
                char c = line_now.charAt(column);
                if (c == '-') {
                    block[row][column] = 1;
                } else {
                    block[row][column] = 0;
                }
            }

        }
        return block;
    }

    void blockOut20_20(int[][] block) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (block[i][j] == 1) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public int[][] fill(int[][] _block, int _x, int _y) {
        if(_x < 0 || _y < 0 || _x >= 20 || _y >= 20){
            return _block;
        }
        if (_block[_x][_y] == 1) {
            return _block;
        } else if (_block[_x][_y] == 0) {
            _block[_x][_y] = 1;
            _block = fill(_block, _x, _y + 1);
            _block = fill(_block, _x, _y - 1);
            _block = fill(_block, _x + 1, _y);
            _block = fill(_block, _x - 1, _y);
            return _block;
        }
        throw new IllegalArgumentException("Invalid block");
    }
}
