import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixConverter {

    public static int[][] matrixInput(Scanner scanner) {

        List<List<Integer>> matrixList = new ArrayList<>();
        String[] line1 = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line1[0]);
        int cols = Integer.parseInt(line1[1]);
        int rowLazy = 0;

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            String[] rowNow = scanner.nextLine().split(" ");
            if (i + 1 != Integer.parseInt(rowNow[0])) {
                for (int j = 0; j < cols; j++) {
                    row.add(0);
                }
                matrixList.add(row);
                rowLazy++;
            } else {
                int colLazy = 0;
                for (int j = 0; j < cols; j++) {
                    if (rowNow.length > j + 1 - colLazy && !rowNow[j + 1 - colLazy].isEmpty()) {
                        String[] colNow = rowNow[j + 1 - colLazy].split(":");
                        int colNum = Integer.parseInt(colNow[0]);
                        int colVal = Integer.parseInt(colNow[1]);
                        if (j + 1 != colNum) {
                            row.add(0);
                            colLazy++;
                        } else {
                            row.add(colVal);
                        }
                    } else {
                        row.add(0);
                    }
                }
                matrixList.add(row);
            }
        }

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrixList.get(i).get(j);
            }
        }

        return matrix;
    }

    public static void matrixOutput(int[][] matrix) {
        System.out.println(matrix.length + " " + matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print((j + 1) + ":" + matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] add(int[][] matrix1, int[][] matrix2) {
        // Check if matrices have the same dimensions
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Error: Matrices are not the same size.");
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2){
        // Check if matrices can be multiplied
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Error: Matrices cannot be multiplied.");

        }
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];

                }

            }

        }
        return result;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix1 = matrixInput(scanner);
        int[][] matrix2 = matrixInput(scanner);
        int[][] result = multiply(matrix1, matrix2);
        matrixOutput(result);
    }
}

