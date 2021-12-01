package lab5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws EmptyList {
        System.out.println("____Task1____");
        String[] list = new String[6];
        for (int i = 0; i < 6; i++) {
            list[i] = String.valueOf(i);
        }
        double ans = Metods.Srednee(list);
        System.out.println("Ansver:" + ans);

        System.out.println("____Task2____ ");
        String[] list2 = new String[6];

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                list2[i] = "even";
            } else {
                list2[i] = "odd";
            }
        }
        Metods.HightNew(list2);

        System.out.println("____Task3____ ");
        String[] list3 = new String[6];
        list3[0] = "2";
        list3[1] = "3";
        list3[2] = "2";
        list3[3] = "5";
        list3[4] = "16";
        list3[5] = "3";
        Metods.Scale(list3);

        System.out.println("____Task4____ ");
        Collection<String> list4= Arrays.asList("cat", "dog", "pig","cartoon","daysy","pasta","rim","return","carate","duck");
        Metods.SortAndChoice(list4,"c");

        System.out.println("____Task5____ ");
        Collection<String> list5= Arrays.asList("cat", "dog", "pig","cartoon","daysy","Pasta","Rim","return","Carate","Duck");
        Metods.LastOrError(list5);

        System.out.println("____Task6____ ");
        int[] list6 = new int[10];
        for (int i = 0; i < 10; i++) {
            list6[i] = i;
        }
        int sum=Metods.SumEven(list6);
        System.out.println(sum);

        System.out.println("____Task7____ ");
        String[] list7= new String[6];
        list7[0] = "cat";
        list7[1] = "dog";
        list7[2] = "bear";
        list7[3] = "pasta";
        list7[4] = "pear";
        list7[5] = "tear";

        Map map=Metods.Maping(list7);
        System.out.println(map);
    }
}

