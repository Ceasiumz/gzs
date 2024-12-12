import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Queens {

    // 判断在给定位置放置皇后是否安全
    private static boolean isSafe(int[][] board, int row, int col, int m, int n) {
        // 检查同一列
        for (int i = 0; i < m; i++) {
            if (i!= row && board[i][col] == 1) {
                return false;
            }
        }

        // 检查左上对角线
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // 检查右上对角线
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    // 递归放置皇后
    private static void placeQueens(int[][] board, int remainingQueens, int startRow, int m, int n, List<List<Integer>> allSolutions) {
        if (remainingQueens == 0) {
            List<Integer> solution = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        solution.add(i*n + j + 1);
                    }
                }
            }
            // 去重处理
            if (!allSolutions.contains(solution)) {
                allSolutions.add(solution);
            }
            return;
        }

        for (int row = startRow; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (isSafe(board, row, col, m, n)) {
                    board[row][col] = 1;
                    placeQueens(board, remainingQueens - 1, row + 1, m, n, allSolutions);
                    board[row][col] = 0;
                }
            }
        }
    }

    // 计算皇后放置的所有可能方案
    public static List<List<Integer>> queensPlacement(int m, int n, int p) {
        int[][] board = new int[m][n];
        List<List<Integer>> allSolutions = new ArrayList<>();
        for (int startRow = 0; startRow < m; startRow++) {
            placeQueens(board, p, startRow, m, n, allSolutions);
        }
        return allSolutions;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] arg = input.nextLine().split(" ");
        if (arg.length!= 3) {
            System.out.println("请输入三个整数参数，分别表示棋盘的行数、列数和皇后的数量");
            return;
        }

        int m = Integer.parseInt(arg[0]);
        int n = Integer.parseInt(arg[1]);
        int p = Integer.parseInt(arg[2]);

        List<List<Integer>> allSolutions = queensPlacement(m, n, p);

        System.out.println(allSolutions.size());

    }
}