package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Double> listDouble = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            listDouble.add((double)((i+1) * 100));
        }
        List<String> listString = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            listString.add(Character.toString((char)(i+(int)('a'))));
        }
        List<Integer> listInt = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            listInt.add(Integer.parseInt(String.valueOf(Math.round(listDouble.get(i)))));// из дабла -> стринг -> инт
        }
        System.out.println(Functional.getAverage(listDouble));
        System.out.println(Functional.newUpper(listString));
        listInt.add(100);
        System.out.println(Functional.forEveryUniqueMakeSquare(listInt));
        listString.add("ac");
        listString.add("ad");
        listString.add("ab");
        System.out.println(Functional.getWithLetterAndSorted(listString, 'a'));
        try {
            System.out.println("We must have three outputs");
            System.out.println(Functional.getLast(listDouble));
            System.out.println(Functional.getLast(listInt));
            System.out.println(Functional.getLast(listString));
            System.out.println("We got three outputs");
            Functional.getLast(new ArrayList<Integer>());
        }
        catch (NoSuchElementException e){
            System.out.println("We have expected error with empty collection");
        }
        listInt.add(3);
        System.out.println("Sum == " +Functional.getSumOfEven(listInt));
        System.out.println("Sum -> " +(Functional.getSumOfEven(listInt) == 5600));
        List<String> listForMap = new ArrayList<>();
        listForMap.add("name");
        listForMap.add("age");
        listForMap.add("profession");
        Map<Character, String> map = Functional.mapByFirstCharacter(listForMap);
        System.out.println(map.get('n'));
        System.out.println(map.get('a'));
    }
}
