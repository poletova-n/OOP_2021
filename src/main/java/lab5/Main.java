package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static double average(int[] array) {
        return Arrays
                .stream(array)
                .average()
                .orElse(Double.NaN);
    }

    public static List<String> toUpperNew(List<String> list) {

        return list
                .stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .collect(Collectors.toList());

    }

    public static List<Integer> squaresFromSingles(List<Integer> list) {
        return list
                .stream()
                .filter(i -> Collections.frequency(list, i) == 1)
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
                .collect(Collectors.toMap((m)->m.charAt(0), (m)->m.substring(1,m.length())));
    }

    public static void main(String[] args) {

        int[] array = { 1, 33, 2, 11, 28 };
        System.out.println("Average among { 1, 33, 2, 11, 28 } is: " + average(array));

        List<String> numbers = Arrays.asList("one","two","three");
        System.out.println("Upper case + _new_ for \"one\",\"two\",\"three\" is: " + toUpperNew(numbers));

        List<Integer> singlesToSquares = Arrays.asList(2,3,3,3,4,4,5,6,7,7);
        System.out.println("Squares of singles from (2,3,3,3,4,4,5,6,7,7) are: " + squaresFromSingles(singlesToSquares));

        List<String> tLetters = Arrays.asList("one","two","three","twelve");
        System.out.println("Words started from t and sorted from \"two\",\"three\",\"twelve\" are: " + firstLetterSorted(tLetters, 't'));

        Collection<String> collection = Arrays.asList("first", "second");
        System.out.println("Last element from \"first\", \"second\" is " + last(collection));

        int[] array3 = { 1, 33, 2, 11, 28 };
        System.out.println("Sum of even among { 1, 33, 2, 11, 28 } is: " + sumOfEven(array3));

        List<String> stringsToMap = Arrays.asList("one","two","five");
        System.out.println("Converting strings \"one\",\"two\",\"three\" to map: " + stringsToMap(stringsToMap));



    }
}
