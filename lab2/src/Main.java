import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        System.out.println("Input filepath: ");
        try {
            Scanner scanner = new Scanner(System.in);
            N = FileAccess.readIntFile(scanner.nextLine());
        } catch (FileEx e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        try {
            if (N > 1000000) throw new NEx("Too much");
        } catch (NEx e) {
            System.out.println(e.toString());
            System.exit(-1);
        }

        int[][] arr = Matrix.randomSquareMatrix(N,-N,N);
        Matrix.printMatrix(arr);
        System.out.println();
        try {
            // 90
            arr = Matrix.turnCounterClockwise90(arr);
            Matrix.multiplyMatrix(arr);
            Matrix.printMatrix(arr);
            // 180
            arr = Matrix.turnCounterClockwise180(arr);
            Matrix.multiplyMatrix(arr);
            Matrix.printMatrix(arr);
            // 270
            arr = Matrix.turnCounterClockwise270(arr);
            Matrix.multiplyMatrix(arr);
            Matrix.printMatrix(arr);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
        Matrix.printMatrix(arr);
    }
}