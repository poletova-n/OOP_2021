package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static double getAverage(int[] array) {
        return Arrays
                .stream(array)
                .average()
                .orElse(Double.NaN);
    }
    public static List<String> upperAddPrefix(List<String> list) {
        return list
                .stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .collect(Collectors.toList());

    }
    public static List<Integer> squareSingles(List<Integer> list) {
        return list
                .stream()
                .filter(i -> Collections.frequency(list, i) == 1)
                .map(num -> num * num)
                .collect(Collectors.toList());
    }
    public static Collection<String> firstLetterSorted(Collection<String> collection, char letter) {
        return collection
                .stream()
                .filter(w -> !w.isEmpty())
                .filter(w -> w.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }
    public static <T> T lastElement(Collection<T> collection) { // последний элемент коллекции
        return collection
                .stream()
                .skip((long) collection.size() > 0 ? (long) collection.size() - 1 : 0)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);

    }
    public static int sumOfEven(int[] array) { // сумма четных
        return Arrays
                .stream(array)
                .reduce(0, (sum, element) -> element % 2 == 0 ? sum + element : sum);
    }
    public static Map<Character, String> stringsToMap(Collection<String> collection) { // список -> map
        return collection
                .stream()
                .filter(s -> s.length() >= 2)
                .collect(Collectors.toMap((m)->m.charAt(0), (m)->m.substring(1)));
    }
    public static void main(String[] args) {
        int[] array1 = {5, 3, 2, 6};
        System.out.println("1. Array average: " + getAverage(array1));

        List<String> array2 = Arrays.asList("to","uPpeR","cASe");
        System.out.println("2. Convert to uppercase with prefix added: " + upperAddPrefix(array2));

        List<Integer> array3 = Arrays.asList(11,5,3,11,2,38,7,38,7,9);
        System.out.println("3. Squaring single values: " + squareSingles(array3));

        List<String> array4 = Arrays.asList("To","Ball","Kid","Keeper","Kick","Red","Key","Wheel");
        System.out.println("4. Output and sorting words starting with the letter \"K\": " + firstLetterSorted(array4, 'K'));

        Collection<Integer> array5 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("5. Output last element: " + lastElement(array5));

        int[] array6 = {1,2,3,4,5,6,7,8};
        System.out.println("6. Sum of even numbers: " + sumOfEven(array6));

        List<String> array7 = Arrays.asList("1first","2second","3third");
        System.out.println("7. Convert strings into a map container: " + stringsToMap(array7));
    }
}