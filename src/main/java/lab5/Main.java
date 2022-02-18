package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Get average: ");
        List<Integer> listAverage = Arrays.asList(5, 4, 3, 2, 1, 0);
        System.out.println("List: " + listAverage);
        System.out.println("Average: " + Methods.getAverage(listAverage));

        System.out.println("\nChange to uppercase and add _new_: ");
        List<String> listLowerCase = Arrays.asList("hero", "horse", "duck", "bird");
        System.out.println("List: " + listLowerCase);
        System.out.println("Result: " + Methods.stringToUpper(listLowerCase));

        System.out.println("\nGet squared unique elements in list: ");
        List<Double> listOfNumbers = Arrays.asList(7.0, 7.0, 7.0, 7.0, 7.0, 3.0, 6.0, 6.0, 5.0, 4.0, 5.0, 5.0);
        System.out.println("List: " + listOfNumbers);
        System.out.println("Result: " + Methods.getUniqueSquare(listOfNumbers));

        System.out.println("\nGet sorted by requested letter strings: ");
        List<String> unsortedList = Arrays.asList("hero", "duck", "horse", "hill", "fear", "exam");
        System.out.println("List: " + unsortedList);
        System.out.println("Result: " + Methods.getFirstLetterSorted(unsortedList, 'h'));

        System.out.println("\nGet last element or throw: ");
        List<Integer> notEmptyList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        System.out.println("List: " + notEmptyList);
        System.out.println("Result: " + Methods.getLast(notEmptyList));

        System.out.println("\nGet sum of even: ");
        List<Integer> listWithEvens = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("List: " + listWithEvens);
        System.out.println("Result: " + Methods.getSumOfEven(listWithEvens));

        System.out.println("\nGet map from list: ");
        List<String> notAMap = Arrays.asList("hero", "duck", "meat", "book", "fear", "exam");
        System.out.println("List: " + notAMap);
        System.out.println("Result: " + Methods.getMapFromList(notAMap));
    }
}