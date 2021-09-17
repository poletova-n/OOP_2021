package lab5;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("1.Get average value of the list:");

        List<Integer> testList = Arrays.asList(1,2,3,4,5);
        System.out.println("List: " + testList);
        System.out.println("Average: " + StreamAPILab.getAverageFromList(testList));



        System.out.println("\n2.Modify and uppercase strings in list: ");

        List<String> testList2 = Arrays.asList("hello", "world", "java", "PrOGrammINg");
        System.out.println("List: " + testList2);
        System.out.println("Result: " + StreamAPILab.stringToUpperCaseInList(testList2));



        System.out.println("\n3.Get squared unique elements in list: ");

        List<Integer> testList3 = Arrays.asList(1,1,1,1,1,2,3,3,4,4,5,6);
        System.out.println("List: " + testList3);
        System.out.println("Result: " + StreamAPILab.squaredUniqueElements(testList3));



        System.out.println("\n4.Get sorted strings with requested letter(requested 'b'): ");

        List<String> testList4 = Arrays.asList("array", "bidirectional", "bubble", "case", "java", "bag");
        System.out.println("List: " + testList4);
        System.out.println("Result: " + StreamAPILab.returnRequestedLetterStrings(testList4,'b'));



        System.out.println("\n5.Get last or throw: ");

        List<Integer> testList5 = Arrays.asList(1,1,1,2,3,3,4,4,5,6);
        List<Integer> emptyLlist = new ArrayList<>();
        System.out.println("List: " + testList5);
        System.out.println("Result: " + StreamAPILab.returnLastOrThrowException(testList5));
//        System.out.println("Result(empty list): " + StreamAPILab.returnLastOrThrowException(emptyLlist));



        System.out.println("\n6.Get sum of even: ");

        List<Integer> testList6 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("List: " + testList6);
        System.out.println("Result: " + StreamAPILab.returnSumOfEven(testList6));


        System.out.println("\n7.Get map from list: ");

        List<String> testList7 = Arrays.asList("hello", "world", "random", "just", "test");
        System.out.println("List: " + testList7);
        System.out.println("Result: " + StreamAPILab.returnMapFromList(testList7));

    }
}
//    С использованием StreamAPI реализовать следующие методы:
//        1. метод, возвращающий среднее значение списка целых чисел;
//        2. метод, приводящий все строки в списке в верхний регистр и
//        добавляющий к ним префикс «_new_»;
//        3. метод, возвращающий список квадратов всех встречающихся
//        только один раз элементов списка;
//        4. метод, принимающий на вход коллекцию строк и возвращающий
//        все строки, начинающиеся с заданной буквы, отсортированные по
//        алфавиту;
//        5. метод, принимающий на вход коллекцию и возвращающий её
//        последний элемент или кидающий исключение, если коллекция
//        пуста;
//        6. метод, принимающий на вход массив целых чисел, возвращающий
//        сумму чётных чисел или 0, если чётных чисел нет;
//        7. метод, преобразовывающий все строки в списке в Map, где первый
//        символ – ключ, оставшиеся – значение;

