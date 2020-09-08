import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = args[0];
        String secondWordList = args[1];

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> res = new ArrayList<>();
        List<String> first = Arrays.asList(firstWordList.split(","));
        List<String> second = Arrays.asList(secondWordList.split(","));
        List<String> finalRes = res;
        first.forEach(item -> {
            if (item.equals("") || !isAbc(item)) throw new RuntimeException("input not valid");
            item = item.toUpperCase();
            String finalItem = item;
            second.forEach(item2 -> {
                if (item2.equals("") || !isAbc(item2)) throw new RuntimeException("input not valid");
                item2 = item2.toUpperCase();
                if (finalItem.equals(item2)) {
                    String[] items = finalItem.split("");
                    finalRes.add(String.join(" ", items));
                }
            });
        });

        res = new ArrayList<>(new HashSet<>(res));

        Collections.sort(res);

        return res;
    }

    private static Boolean isAbc(String tap) {
        Pattern pattern = Pattern.compile("([a-z]|[A-Z])*");
        return pattern.matcher(tap).matches();
    }
}
