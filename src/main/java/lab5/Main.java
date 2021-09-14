package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static lab5.Instruments.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("lalaA");
        strings.add("lal");
        strings.add("lol");

        System.out.println(getMapWhereFirstLatterIsKey(strings));

    }
}