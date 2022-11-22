import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final HashMap<String, String> dictionary = new HashMap<>();
    private static String translation = "";
    public static void main(String[] args) {
        try {
            loadDictionary(args[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDictionary(String path) throws FileNotFoundException {
        if (path.isBlank()) {
            throw new RuntimeException("Задан пустой путь к словарю");
        }
        File file = new File(path);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new RuntimeException("Невозможно открыть словарь");
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\|");
                String key = line[0].trim().toLowerCase();
                String value = line[1].trim().toLowerCase();
                dictionary.put(key, value);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не найден");
        }
    }


}