import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static class Matrix {
        private final int[][] matrix;
        private final int rows;
        private final int columns;

        public Matrix(int[][] matrix) {//int[rows][columns]
            this.matrix = matrix;
            this.rows = matrix.length;
            this.columns = matrix[0].length;
        }

        public static Matrix Matrixmultiply(Matrix a, Matrix b) {//M a * M b = M c
            if(a.columns==b.rows){
                Matrix c = new Matrix(new int[a.rows][b.columns]);
            int arowcounter = 0;
            int[] rowab = new int[b.rows];
            for (int[] rowa : a.matrix) {//for each row in a
                for (int bcolcounter = 0; bcolcounter < b.columns; bcolcounter++) {//for each column in b
                    for(int i = 0; i < b.rows; i++){
                        try{rowab[i] = rowa[i] * b.matrix[i][bcolcounter];}
                        catch (Exception e){break;}
                    }
                    c.matrix[arowcounter][bcolcounter] = Arrays.stream(rowab).sum();
                }
                arowcounter++;
            }
            return c;
        }
            else {
                System.out.println("a.column!=b.row");
                return null;
            }
        }

        public static int[][] MatrixInput(Scanner input, int rows, int columns) {//input matrix
            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++)
                    matrix[i][j] = input.nextInt();
            }
            return matrix;
        }

        public static void MatrixOutput(Matrix matrix) {//output matrix
            try (PrintStream output = System.out) {
                output.printf("%d %d\n", matrix.rows, matrix.columns);
                for (int[] row : matrix.matrix) {
                    for (int i : row)
                        System.out.print(i + " ");
                    System.out.println();
                }
            }
        }

        public static void main(String[] args) {
            Matrix a, b;
            try (Scanner input = new Scanner(System.in)) {
                int[] para = Arrays.stream(input.nextLine().split("")).filter(s -> !s.equals(" "))//in
                        .mapToInt(Integer::parseInt).toArray();//out
                a = new Matrix(Matrix.MatrixInput(input, para[0], para[1]));
                b = new Matrix(Matrix.MatrixInput(input, para[1], para[2]));
            }
            MatrixOutput(Objects.requireNonNull(Matrixmultiply(a, b)));
        }
    }
}