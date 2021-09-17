package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lab5.Instruments.*;

public class Main {
    public static void main(String[] args) {
        List<String> stringList3 = new ArrayList<>();
        stringList3.add("labs");
        stringList3.add("1lab 1");
        stringList3.add("2lab 2");
        stringList3.add("3lab 3");
        stringList3.add("alab 4");
        stringList3.add("blab 5");

        Map<Character, String> CheckPlease = getMapWhereFirstLatterIsKey(stringList3);
        System.out.println(CheckPlease);
    }
}