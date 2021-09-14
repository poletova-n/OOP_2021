package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Instruments {

    public static double getAverageOfIntegers(List<Integer> numbers){
    double average;
    if (numbers == null || numbers.isEmpty())
      return 0;
    average = numbers.stream()
            .reduce((a, b) -> a + b)
            .get();
    average /= numbers.size();
    return average;
  }
  public static void makeUpperCaseAndAddPrefix(List<String> strings){
      StringBuilder sb = new StringBuilder();
      List<String> result =
      strings.stream()
              .map(i -> {
                  sb.delete(0,sb.length());
                  sb.append("_new_").append(i.toUpperCase());
                  return sb.toString();
              })
              .collect(Collectors.toList());
      strings.removeAll(strings);
      strings.addAll(result);
  }
  public static List<Double> getSingularQuadratures(List<Double> numbers){
     return numbers.stream()
              .distinct()
              .map(i -> i * i)
              .collect(Collectors.toList());
  }

  public static List<String> getListStartingWithLetterAndSort(Character letter, Collection<String> blank) {

      return blank.stream()
              .filter(i -> i.charAt(0) == letter)
              .sorted()
              .collect(Collectors.toList());
  }

  public static <T> T getLastElementOrElseThrow(Collection<T> collection) throws NoSuchElementException{
      if (collection.isEmpty())
          throw new NoSuchElementException("No elements in collection");

      return collection.stream()
              .reduce((first, second) -> second)
              .get();
  }

  public static int getCountableSumOrElseNull(int[] numbers){
      int sum = 0;
      sum = Arrays.stream(numbers)
              .filter(i-> i%2 == 0)
              .sum();
      return sum;
  }

  public static Map<Character,List<String>> getMapWhereFirstLatterIsKey(List<String> list){
      return list.stream()
              .collect(Collectors.groupingBy(s -> s.charAt(0)));
  }

}
