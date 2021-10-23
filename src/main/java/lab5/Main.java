package lab5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static lab5.Functions.*;

public class Main {
    public static void main(String[] args) {

        int[] array = { 1, 33, 2, 11, 28 };
        System.out.println("Average is: " + Functions.getAverage(array));

        List<String> numbers = Arrays.asList("A","B","C");
        System.out.println("Upper case + _new_  is: " + Functions.changeString(numbers));

        List<Integer> singlesToSquares = Arrays.asList(2,3,3,3,4,4,5,6,7,7);
        System.out.println("Squares of singles are: " + Functions.getSquare(singlesToSquares));

        List<String> tLetters = Arrays.asList("one","two","three","twelve");
        System.out.println("Words started from t and sorted are: " + Functions.firstLetterSorted(tLetters, 't'));

        Collection<String> collection = Arrays.asList("first", "second");
        System.out.println("Last element is " + Functions.last(collection));

        int[] array3 = { 1, 33, 2, 11, 28 };
        System.out.println("Sum of even is: " + Functions.sumOfEven(array3));

        List<String> stringsToMap = Arrays.asList("one","two","five");
        System.out.println("Converting strings to map: " + Functions.stringsToMap(stringsToMap));
    }
}


