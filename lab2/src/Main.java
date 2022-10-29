import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        System.out.println("Input filepath: ");
        try {
            Scanner scanner = new Scanner(System.in);
            N = FileAccess.ReadIntFile(scanner.nextLine());
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

        System.out.println(N);
    }
}