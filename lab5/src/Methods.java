import java.util.List;

public class Methods {
    public static double task1(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    public static List<String> task2(List<String> list) {
        return list.stream()
                .map(str -> str = str.toUpperCase())
                .map(str -> str = "_new_" + str)
                .toList();
    }
}
