import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        System.out.println("Input filepath: ");
        try {
            Scanner scanner = new Scanner(System.in);
            N = FileAccess.ReadIntFile(scanner.nextLine());
        } catch (Ex e) {
            System.out.println(e.toString());
        }
        System.out.println(N);
    }
}