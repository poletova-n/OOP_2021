package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Functions {

    public static double getAverage(int[] arr){
        return Arrays
                .stream(arr)
                .average()
                .orElse(Double.NaN);
    }
    public static List<String> changeString(List<String> list) {
        return list
                .stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .collect(Collectors.toList());

    }
    public static List<Integer> getSquare(List<Integer> list) {
        return list
                .stream()
                .distinct()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    public static Collection<String> firstLetterSorted(Collection<String> collection, char letter) {
        return collection
                .stream()
                .filter(s -> !s.isEmpty())
                .filter(s -> s.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T last(Collection<T> collection) {
        return collection
                .stream()
                .skip((long) collection.size() > 0 ? (long) collection.size() - 1 : 0)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);

    }

    public static int sumOfEven(int[] array) {
        return Arrays
                .stream(array)
                .reduce(0, (subtotal, element) -> element % 2 == 0 ? subtotal + element : subtotal);
    }

    public static Map<Character, String> stringsToMap(Collection<String> collection) {
        return collection
                .stream()
                .filter(s -> s.length() >= 2)
                .collect(Collectors.toMap((m)->m.charAt(0), (m)->m.substring(1)));
    }


}
