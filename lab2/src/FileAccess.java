import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileAccess {
    public static int ReadIntFile(String filePath) throws FileEx {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.isFile()) {
                try {
                    return getInt(file);
                } catch (InputMismatchException e) {
                    throw new FileEx("Incorrect data type");
                } catch (FileNotFoundException e) {
                    throw new FileEx("File not exists");
                }
            } else throw new FileEx("Not a file");
        } else throw new FileEx("File not exists");
    }

    private static int getInt(File file) throws InputMismatchException, FileNotFoundException {
        Scanner scan = new Scanner(file);
        int data = -1;
        while (data == -1) {
                data = scan.nextInt();
        }
        return data;
    }
}
