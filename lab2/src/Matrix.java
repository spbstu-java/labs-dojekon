import java.util.Random;

public class Matrix {

    public static void multiplyMatrix(int[][] matrix) throws MathEx {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftIndex = (j == 0) ? (m - 1) : (j - 1);
                int rightIndex = (j == m - 1) ? (0) : (j + 1);
                int divider = matrix[i][leftIndex] + matrix[i][rightIndex];
                if (divider == 0) {
                    throw new MathEx("Деление на ноль невозможно");
                }
                matrix[i][j] /= divider;
            }
        }
    }
    public static int[][] turnCounterClockwise90(int[][] a) {
        int[][] b = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[a.length -
                        1 - j][i] = a[i][j];
            }
        }
        return b;
    }

    public static int[][] turnCounterClockwise180(int[][] a) {
        return turnCounterClockwise90(turnCounterClockwise90(a));
    }

    public static int[][] turnCounterClockwise270(int[][] a) {
        return turnCounterClockwise180(turnCounterClockwise90(a));
    }
        public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] randomSquareMatrix(int n, int min, int max) {
        int[][] a = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = min +  rand.nextInt(max - min + 1);
            }
        }
        return a;
    }
}
