package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {

    public static double getAverage(List<Integer> num){
        return num
                .stream()
                .mapToInt(x -> x)
                .average().getAsDouble();
    }

    public static List<String> stringToUpper(List<String> strings){
        return strings
                .stream()
                .map(String::toUpperCase)
                .map(s -> ("_new_" + s))
                .collect(Collectors.toList());
    }

    public static List<Double> getUniqueSquare(List<Double> arr){
        return  arr
                .stream()
                .filter(i -> Collections.frequency(arr, i) == 1)
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    public static List<String> getFirstLetterSorted(List<String> collection, char letter){
        return collection
                .stream()
                .filter(x -> x.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLast(Collection<T> collection){
        return collection
                .stream()
                .skip(collection.size() - 1)
                .findAny()
                .orElseThrow();
    }

    public static int getSumOfEven(List<Integer> arr){
        return arr
                .stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();
    }


    public static Map<Character, String> getMapFromList(List<String> list) {

        return list
                .stream()
                .filter(s -> s.length() >= 2)
                .collect(Collectors.toMap((m) -> m.charAt(0), (m) -> m.substring(1)));
    }
}