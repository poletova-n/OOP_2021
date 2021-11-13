package lab5;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("1.Get average value of the list:");

        List<Integer> testList = Arrays.asList(1,1,2,3,3,4,5,5,7,8);
        System.out.println("List: " + testList);
        System.out.println("Average: " + StreamAPILab.getAverage(testList));



        System.out.println("\n2.Modify and uppercase strings in list and add to them _new_: ");

        List<String> testList2 = Arrays.asList("hi", "my", "name", "is Potato");
        System.out.println("List: " + testList2);
        System.out.println("Result: " + StreamAPILab.stringToUpperCase(testList2));



        System.out.println("\n3.Get squared unique elements in list: ");

        List<Integer> testList3 = Arrays.asList(1,1,2,3,3,4,5,5,7,8);
        System.out.println("List: " + testList3);
        System.out.println("Result: " + StreamAPILab.squaredUniqueElements(testList3));



        System.out.println("\n4.Get sorted strings with requested letter(requested 'a'): ");

        List<String> testList4 = Arrays.asList("array", "bidirectional", "bubble", "case", "java", "bag");
        System.out.println("List: " + testList4);
        System.out.println("Result: " + StreamAPILab.returnRequestedLetterStrings(testList4,'a'));



        System.out.println("\n5.Get last or throw: ");

        List<Integer> testList5 = Arrays.asList(1,1,2,3,3,4,5,5,7,8);
        System.out.println("List: " + testList5);
        System.out.println("Result: " + StreamAPILab.returnLastOrThrowException(testList5));




        System.out.println("\n6.Get sum of even: ");

        List<Integer> testList6 = Arrays.asList(1,1,2,3,3,4,5,5,7,8);
        System.out.println("List: " + testList6);
        System.out.println("Result: " + StreamAPILab.returnSumOfEven(testList6));


        System.out.println("\n7.Get map from list: ");

        List<String> testList7 = Arrays.asList("hello", "world", "potato", "just", "test");
        System.out.println("List: " + testList7);
        System.out.println("Result: " + StreamAPILab.returnMapFromList(testList7));

    }
}
