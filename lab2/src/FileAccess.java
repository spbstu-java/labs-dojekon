import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileAccess {
    public static int ReadIntFile(String filePath) throws Ex  {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.isFile()) {
                try {
                    return getInt(file);
                } catch (InputMismatchException e) {
                    throw new Ex("Incorrect data type");
                } catch (FileNotFoundException e) {
                    throw new Ex("File not exists");
                }
            } else throw new Ex("Not a file");
        } else throw new Ex ("File not exists");
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
