import java.util.*;
import java.util.stream.Collectors;

public class Utility {
    public int getArithmeticMean(List<Integer> listOfNumbers) {
        assert listOfNumbers != null;
        if (listOfNumbers.isEmpty())
            throw new IllegalArgumentException("You must not pass an empty list");
        return listOfNumbers.stream()
                .mapToInt(i -> i)
                .sum() / listOfNumbers.size();
    }
    public List<String> getLineModifier (List<String> listOfStrings) {
        assert listOfStrings != null;
        if (listOfStrings.isEmpty())
            throw new IllegalArgumentException("You must not pass an empty list");
        return listOfStrings.stream()
                .map(String::toUpperCase)
                .map(s -> "_new_" + s)
                .collect(Collectors.toList());
    }
    public List<Integer> getListOfSquares (List<Integer> listOfNumbers) {
        if (listOfNumbers == null || listOfNumbers.isEmpty())
            throw new IllegalArgumentException("You must not pass an empty list");
        return listOfNumbers.stream()
                .filter(n-> Collections.frequency(listOfNumbers, n) == 1)
                .map(s -> s * s)
                .collect(Collectors.toList());
    }
    public List<String> getListOfSortedStrings (List<String> listOfStrings, Character character) {
        assert listOfStrings != null;
        if (listOfStrings.isEmpty())
            throw new IllegalArgumentException("You must not pass an empty list");
        return listOfStrings.stream()
                .filter(s -> !s.isEmpty())
                .filter(s-> character == s.charAt(0))
                .sorted()
                .collect(Collectors.toList());
    }
    public <T> T getLastElementOfCollection (Collection<T> collection) {
        assert collection != null;
        if (collection.isEmpty())
            throw new IllegalArgumentException("You must not pass an empty collection");
        return collection.stream()
                .reduce((e1, e2) -> e2)
                .orElse(null);
    }
    public int getSumOfEvenNumbers(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("You must not pass an empty list");
        return Arrays.stream(array)
                .filter(n-> n % 2 == 0)
                .sum();
    }
    public Map<Character, String> getMapFromList(Collection<String> collection) {
        return collection.stream()
                .filter(elem -> elem.length() > 1)
                .collect(Collectors.toMap(key-> key.charAt(0), item -> item.substring(1)));
    }
}
