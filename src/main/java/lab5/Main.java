package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lab5.Instruments.*;

public class Main {
    public static void main(String[] args) {
        List<String> stringList3 = new ArrayList<>();
        stringList3.add("qw");
        stringList3.add("qqer");
        stringList3.add("wer");
        stringList3.add("");
        stringList3.add("awer");
        stringList3.add("aav");
        stringList3.add("aav");
        Map<Character, List<String>> karta = getMapWhereFirstLatterIsKey(stringList3);
        System.out.println(karta);

    }
}