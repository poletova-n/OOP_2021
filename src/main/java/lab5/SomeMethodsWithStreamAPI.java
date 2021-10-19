package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class SomeMethodsWithStreamAPI {

    // #1
    public double averageOfIntegers(List<Integer> collection) {
        OptionalDouble average =  collection.stream()
                                    .mapToInt(x -> x)
                                    .average();
        return (average.isEmpty() ? 0 : average.getAsDouble());
    }

    // #2
    public List<String> modifyStringAndSort(List<String> collection) {
        return collection.stream()
                .map(String::toUpperCase)
                .map(s -> "_new_" + s)
                .collect(Collectors.toList());
    }

    // #3
    public List<Integer> squaresOfUnique(List<Integer> collection) {
        return collection.stream()
                .filter(x -> Collections.frequency(collection, x) == 1)
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    // #4
    public List<String> sortByTheFirstLatter(List<String> collection, String letter) {
        return collection.stream()
                .filter(s -> s.startsWith(letter))
                .sorted()
                .collect(Collectors.toList());
    }

    // #5
    public <T> T returnLastElement(List<T> collection) {
        return collection.stream()
                .skip(collection.size() - 1)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);

    }

    // #6
    public int sumOfEven(int[] collection) {
        return Arrays.stream(collection)
                .filter((x) -> x % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    // #7
    public Map<Character, String> makeMap(List<String> collection) {
        return collection
                .stream()
                .filter(s -> s.length() >= 2)
                .collect(Collectors.toMap((s)->s.charAt(0), (s)->s.substring(1)));
    }
}
