package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        System.out.println("Get average: ");
        List<Integer> testList = Arrays.asList(1,2,3,4,5,6);
        System.out.println("List: " + testList);
        System.out.println("Average: " + StreamAPIMethods.getAverage(testList));

        System.out.println("\nModify and uppercase strings in list: ");
        List<String> testList2 = Arrays.asList("hello", "world", "java", "c++");
        System.out.println("List: " + testList2);
        System.out.println("Result: " + StreamAPIMethods.stringToUpperAndNew(testList2));

        System.out.println("\nGet squared unique elements in list: ");
        List<Double> testList3 = Arrays.asList(1.0,1.0,1.0,1.0,1.0,2.0,3.0,3.0,4.0,4.0,5.0,6.0);
        System.out.println("List: " + testList3);
        System.out.println("Result: " + StreamAPIMethods.square(testList3));

        System.out.println("\nGet sorted strings with requested letter: ");
        List<String> testList4 = Arrays.asList("array", "bidirectional", "bubble", "case", "java", "bag");
        System.out.println("List: " + testList4);
        System.out.println("Result: " + StreamAPIMethods.sortByLetter(testList4,'b'));

        System.out.println("\nGet last or throw: ");
        List<Integer> testList5 = Arrays.asList(1,1,1,2,3,3,4,4,5,6);
/*        List<Integer> testListEmpty = Arrays.asList();*/
        System.out.println("List: " + testList5);
        System.out.println("Result: " + StreamAPIMethods.returnLast(testList5));
/*        System.out.println("Result: " + StreamAPIMethods.returnLast(testListEmpty));*/

        System.out.println("\nGet sum of even: ");
        List<Integer> testList6 = Arrays.asList(1,2,3,4,5,6);
        System.out.println("List: " + testList6);
        System.out.println("Result: " + StreamAPIMethods.getEvenSum(testList6));

        System.out.println("\nGet map from list: ");
        List<String> testList7 = Arrays.asList("hello", "world", "random", "just", "test");
        System.out.println("List: " + testList7);
        System.out.println("Result: " + StreamAPIMethods.returnMapFromList(testList7));
    }
}
