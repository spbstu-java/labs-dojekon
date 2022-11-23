import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final HashMap<String, String> dictionary = new HashMap<>();
    private static String translation = "";
    private static int maxLengthOfCollocation = 0;
    public static void main(String[] args) {
        try {
            loadDictionary(args[0]);
            translateFile(args[1]);
            translation = translation.trim();
            System.out.println(translation);
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
                int length = key.split(" ").length;
                if (length > maxLengthOfCollocation) maxLengthOfCollocation = length;
                String value = line[1].trim().toLowerCase();
                dictionary.put(key, value);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не найден");
        }
    }

    public static void translateFile(String path) throws FileNotFoundException  {
        if (path.isBlank()) {
            throw new RuntimeException("Задан пустой путь к словарю");
        }
        File file = new File(path);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new RuntimeException("Невозможно открыть словарь");
        }
        List<String> wordlist = new ArrayList<>();
        try (Scanner scannerText = new Scanner(file)) {
            while (scannerText.hasNext()) {
                wordlist.add(scannerText.next().toLowerCase());
            }
        }
        for (int i = 0; i < wordlist.size(); i++) {
            String phraseTrans = null; // Перевод фразы
            int lastFind = 0; // Индекс последнейго слова, которое дало результат
            for (int j = 0; j < maxLengthOfCollocation && j+i < wordlist.size(); j++) { // Берём слова из списка,
                // но не больше чем размер списка и не больше, чем слов в максимальном словосочетании
                String currPhrase = ""; // Текущее словосочетание
                String currTrans = null; // Перевод текущего словосочетания
                for (int k = 0; k <= j && i+k < wordlist.size(); k++) { // Цикл для получения фразы для перевода
                    currPhrase += wordlist.get(i+k) + " ";
                }
                if (dictionary.get(currPhrase.trim()) != null)
                    currTrans = dictionary.get(currPhrase.trim()); // Если для текущей фразы существует
                // перевод, то сохраняем его во временную переменную
                if (currTrans != null) { // Если перевод найден
                    lastFind = i+j; // Запоминаем, какой индекс принёс результат
                    phraseTrans = currTrans; // Передаём фразу выше
                }
            }
            if (phraseTrans == null) translation += wordlist.get(i); // Если перевод не найден, то сохраняем оригинал
            else translation += phraseTrans + " "; // Иначе, сохраняем перевод
            i = lastFind; // Продолжаем с результирующего места
        }
    }
}