package lab5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StreamAPI task = new StreamAPI();

        List<Integer>   test1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String>    test2 = Arrays.asList("strA", "strB", "strC");
        List<Integer>   test3 = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 4);
        List<String>    test4 = Arrays.asList("int", "double", "void", "long int", "long long");
        List<String>    test5 = Arrays.asList("a", "b", "c", "d", "e");
        int[]           test6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String>    test7 = Arrays.asList("random", "test", "word", "for", "seven");

        try {
            System.out.println("1) " + task.averageOfIntegers(test1));
            System.out.println("2) " + task.modifyStringAndSort(test2));
            System.out.println("3) " + task.squaresOfUnique(test3));
            System.out.println("4) " + task.sortByTheFirstLatter(test4, "l"));
            System.out.println("5) " + task.returnLastElement(test5));
            System.out.println("6) " + task.sumOfEven(test6));
            System.out.println("7) " + task.makeMap(test7));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}