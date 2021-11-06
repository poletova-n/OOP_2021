import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Utility object = new Utility();
            System.out.println("________Methods with numbers________");
            List<Integer> num = new ArrayList<>();
            int []array = new int[5];
            System.out.println("Enter 5 numbers what you want to put in collection:");
            for (int i = 0; i < 5; ++i) {
                int element = scan.nextInt();
                num.add(element);
                array[i] += element;
            }
            System.out.println("Answer - " + object.getArithmeticMean(num));
            System.out.println("Answer - " + object.getListOfSquares(num));
            System.out.println("Answer - " + object.getSumOfEvenNumbers(array));

            System.out.println("________Methods with strings________");
            List<String> strings = new ArrayList<>();
            System.out.println("Enter 5 strings what you want to put in collection:");
            for (int i = 0; i < 5; ++i) {
                String element = scan.nextLine();
                strings.add(element);
            }
            System.out.println("Answer - " + object.getLineModifier(strings));
            System.out.println("Answer - " + object.getListOfSortedStrings(strings, 'f'));
            System.out.println("Answer - " + object.getLastElementOfCollection(strings));
            System.out.println("Answer - " + object.getMapFromList(strings));
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
