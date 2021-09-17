package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPILab {

    //1 - completed
    public static double getAverageFromList(List<Integer> list){

        return list.stream()
                .mapToInt(x -> x)
                .average()
                .getAsDouble();

    }

    // 2 - completed
    public static List<String> stringToUpperCaseInList(List<String>list){

        return list.stream()
                .map(String::toUpperCase)
                .map(s -> "_new_" + s)
                .collect(Collectors.toList());

    }

    //3 - completed
    public static List<Integer> squaredUniqueElements(List<Integer> list){

        return list.stream()
                .filter(x -> Collections.frequency(list,x) == 1)
                .map(x -> x * x)
                .toList();

    }

    //4 - completed
    public static List<String> returnRequestedLetterStrings(List<String> list, char letter){

        return list.stream()
                .filter(x -> x.charAt(0) == letter)
                .sorted()
                .toList();

    }

    //5 - completed
    public static <T> T returnLastOrThrowException(Collection<T> collection) throws NoSuchElementException {

        if (collection.isEmpty()){
            throw new NoSuchElementException("Collection is empty!");
        }

        return collection.stream()
                .reduce((first, second) -> second)
                .get();

    }

    //6 - completed
    public static int returnSumOfEven(List<Integer> array){

        return array.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();

    }

    //7 - completed
    public static Map<Character, String> returnMapFromList(List<String> list) {

        return list
                .stream()
                .filter(s -> s.length() >= 2)
                .collect(Collectors.toMap((m)->m.charAt(0), (m)->m.substring(1)));

    }

}
