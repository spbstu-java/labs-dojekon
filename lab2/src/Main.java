import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
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
        String output;
       while(true) {
           int[][] arr = Matrix.randomSquareMatrix(N,-N,N);
           /*
           Matrix.printMatrix(arr);
           System.out.println();
           */
           output = Arrays.deepToString(arr);
           try {
               // 90
               arr = Matrix.turnCounterClockwise90(arr);
               Matrix.multiplyMatrix(arr);
               /*
               System.out.println("Поворот на 90 и деление");
               Matrix.printMatrix(arr);
               System.out.println();
                */
               output += "\nПоворот на 90 и деление:\n" + Arrays.deepToString(arr);
               // 180
               arr = Matrix.turnCounterClockwise180(arr);
               Matrix.multiplyMatrix(arr);
               /*
               System.out.println("Поворот на 180 и деление");
               Matrix.printMatrix(arr);
               System.out.println();
                */
               output += "\nПоворот на 180 и деление:\n" + Arrays.deepToString(arr);
               // 270
               arr = Matrix.turnCounterClockwise270(arr);
               Matrix.multiplyMatrix(arr);
               /*
               System.out.println("Поворот на 270 и деление");
               Matrix.printMatrix(arr);
               System.out.println();
                */
               output += "\nПоворот на 270 и деление:\n" + Arrays.deepToString(arr);
               break;
           } catch (Exception e) {
               System.out.println(e.toString());
               continue;
           }
       }
        try (PrintWriter out = new PrintWriter("output.txt")) {
            out.println(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}