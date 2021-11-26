package lab5;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIMethods {

    public static double getAverage(List<Integer> num){
        return num.stream()
                .mapToInt(x -> x)
                .average().getAsDouble();
    }

    public static List<String> stringToUpperAndNew(List<String> strings){
        return strings.stream()
                .map(String::toUpperCase)
                .map(s -> ("_new_" + s))
                .collect(Collectors.toList());
    }

    public static List<Double> square(List<Double> arr){
        return  arr.stream()
                .distinct().map(x -> x * x)
                .collect(Collectors.toList());
    }

    public static List<String> sortByLetter(List<String> collection, char letter){
        return collection.stream()
                .filter(x -> x.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T returnLast(Collection<T> collection){
        return collection.stream().skip(collection.size() - 1).findAny().orElseThrow();
    }

    public static int getEvenSum(List<Integer> arr){
        return arr.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();
    }


    public static Map<Character, String> returnMapFromList(List<String> list) {

        return list
                .stream()
                .filter(s -> s.length() >= 2)
                .collect(Collectors.toMap((m) -> m.charAt(0), (m) -> m.substring(1)));
    }
}
