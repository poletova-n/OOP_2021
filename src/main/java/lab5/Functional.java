package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Functional {
    static double getAverage(List<Double> numbers){
        double result = numbers.stream()
                .reduce(((aDouble, aDouble2) -> aDouble + aDouble2))
                .get();
        return (result / numbers.stream().count());
    }
    static List<String> newUpper(List<String> strings){
        List<String> newUpperList =  strings.stream()
                .map(i -> {
                    String builder = "";
                    builder = "_new_" + i.toUpperCase(Locale.ROOT);
                    return builder;
                })
                .collect(Collectors.toList());
        return newUpperList;
    }
    static  List<Integer> forEveryUniqueMakeSquare(List<Integer> ints){
        return ints.stream()
                .filter(n -> Collections.frequency(ints, n) == 1)
                .map(n -> n*n)
                .collect(Collectors.toList());
    }
    static List<String> getWithLetterAndSorted(List<String> strings, Character letter){
        return strings.stream()
                .filter(n -> letter == n.charAt(0))
                .sorted()
                .collect(Collectors.toList());
    }
    static <T> T getLast(List<T> list) throws NoSuchElementException{
        if (list.isEmpty())
            throw new NoSuchElementException("The list is empty");
        return list.stream()
                .reduce((first, last) -> last)
                .get();
    }
    static int getSumOfEven(List<Integer> ints){
        if (ints.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
                .isEmpty()){
            return 0;
        }
        return ints.stream()
                .filter(n -> n % 2 == 0)
                .reduce((first,second) -> first + second)
                .get();
    }
    static Map<Character, String> mapByFirstCharacter(List<String> listString){
        return listString.stream()
                .filter(elem -> elem.length() > 1)
                .filter(elem -> Collections.frequency(listString, elem) == 1)
                .collect(Collectors.toMap((key) -> key.charAt(0), (value) -> value.substring(1)));
    }

}
