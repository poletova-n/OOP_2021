package lab5;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            List<Integer> array = new ArrayList<>();
            array.add(4);
            array.add(3);
            array.add(3);
            array.add(1);
            array.add(2);
            array.add(9);
            array.add(6);
            array.add(6);

            System.out.println(StreamApiRealis.getAverage(array)); //1

            List<String> strArray = new ArrayList<>();
            strArray.add("Heybaby");
            strArray.add("00000024itsmyregion34");
            strArray.add("44zxcxzc20vrqweeqevtbscscscs");
            strArray.add("");
            strArray.add("XfsdfcDSfvx3212vFVF9");
            strArray.add("shokalacomitasuskeloh");
            strArray.add("pikolomarriokonina");

            System.out.println(StreamApiRealis.changeStrings(strArray)); //2

            System.out.println(StreamApiRealis.getUniSquared(array)); //3

            System.out.println(StreamApiRealis.getSatisfyingStrings(strArray, '4')); //4

            System.out.println(StreamApiRealis.getLastElement(array));//5
            System.out.println(StreamApiRealis.getLastElement(strArray));

            //List<String> emptyArray = new ArrayList<>();
            //System.out.println(Utils.getTail(emptyArray));

            int [] arrWithEven = {2, 2, 9, 0, 1, 22, 4, 7, 4, 3};
            int [] arrWithoutEven = {1, 7, 3, 11, 9};

            System.out.println(StreamApiRealis.getSumEven(arrWithEven));//6
            System.out.println(StreamApiRealis.getSumEven(arrWithoutEven));

            System.out.println(StreamApiRealis.ListToMap(strArray));//7
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}