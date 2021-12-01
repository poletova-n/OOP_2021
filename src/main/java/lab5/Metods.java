package lab5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Metods {

    static double Srednee(String[] list) {
        Stream<String> arr = Arrays.stream(list);
        double el = arr.collect(Collectors.averagingInt(num -> Integer.parseInt(String.valueOf(num))));
        return el;

    }

    static void HightNew(String[] list) {
        Stream<String> arr = Arrays.stream(list);
        arr.map(String::toUpperCase).map((e) -> "_new_" + e).forEach(System.out::println);
    }

    static void Scale(String[] list) {
        Stream<String> arr = Arrays.stream(list);
        arr.distinct().map(Integer::parseInt).map((e) -> e * e).forEach(System.out::println);
    }

    static void SortAndChoice(Collection<String> list, String string) {
        list.stream().sorted().filter(e -> e.toLowerCase().startsWith(string)).forEach(System.out::println);
    }

    static void LastOrError(Collection<String> list) {
        int count = (int) list.stream().count();
        if (count == 0) {
            try {
                throw new EmptyList("Empty list,sorry.");
            } catch (EmptyList e) {
                e.printStackTrace();
            }
        } else {
            list.stream().skip(count - 1).forEach(System.out::println);
        }
    }
    public static int SumEven(int[] list){
        IntStream arr = Arrays.stream(list);
        int sum = arr.filter(e-> (e % 2)==0).sum();
        return sum;
    }

    public static Map<Character, List<String>> Maping(String[] list){
        Stream<String> arr = Arrays.stream(list);
        return arr.collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

};
