package com.lab5;

import lab3.exceptions.QueueUnderFlow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lab5.Instruments.*;
import static lab5.Instruments.getLastElementOrElseThrow;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class Main {

    Stream<Integer> infiniteStream = Stream.iterate(1, i -> i + 1);
    Stream<Integer> infiniteZeroes = Stream.iterate(0, i -> i);

    @Test
    @DisplayName("Function getAverageOfIntegers - CORRECT TEST")
    public void getAverageOfIntegersCorrect() {

        List<Integer> listInteger = infiniteStream.limit(10).collect(Collectors.toList());
        Assertions.assertEquals(5.5, getAverageOfIntegers(listInteger));
    }

    @Test
    @DisplayName("Function getAverageOfIntegers - INCORRECT TEST")
    public void getAverageOfIntegersIncorrect(){
        List<Integer> test1 = null;
        List<Integer> test2 = new LinkedList<>();

        Assertions.assertEquals(0, getAverageOfIntegers(test1));
        Assertions.assertEquals(0, getAverageOfIntegers(test2));
    }

    @Test
    @DisplayName("Function makeUpperCaseAndAddPrefix - CORRECT TEST")
    public void makeUpperCaseAndAddPrefixCorrect() {
        List<String> strings = new LinkedList<>();
        strings.add("Hello");
        strings.add("Dear");
        strings.add("Girl");
        strings.add("");
        strings.add("!");

        List<String> stringsCR = new LinkedList<>();
        stringsCR.add("_new_HELLO");
        stringsCR.add("_new_DEAR");
        stringsCR.add("_new_GIRL");
        stringsCR.add("_new_");
        stringsCR.add("_new_!");

        makeUpperCaseAndAddPrefix(strings);
        Assertions.assertEquals(stringsCR, strings);
    }

    @Test
    @DisplayName("Function makeUpperCaseAndAddPrefix - INCORRECT TEST")
    public void makeUpperCaseAndAddPrefixIncorrect() {
        List<String> stringList1 = null;
        List<String> stringList2 = new LinkedList<>();
        makeUpperCaseAndAddPrefix(stringList1);  // no throw
        makeUpperCaseAndAddPrefix(stringList2);  // no throw
    }

    @Test
    @DisplayName("Function getSingularQuadratures - CORRECT TEST")
    public void getSingularQuadraturesCorrect() {
        List<Double> numbers = new LinkedList<>();
        numbers.add(1d);
        numbers.add(2d);
        numbers.add(-1d);
        numbers.add(-2d);
        numbers.add(10d);
        numbers.add(-10d);
        numbers.add(1d);
        numbers.add(2d);
        Assertions.assertEquals(getSingularQuadratures(numbers)
                .toString(), "[1.0, 4.0, 1.0, 4.0, 100.0, 100.0]");
    }

    @Test
    @DisplayName("Function getSingularQuadratures - INCORRECT TEST")
    public void getSingularQuadraturesIncorrect() {
        List<Double> numbers1 = null;
        List<Double> numbers2 = new LinkedList<>();
        getSingularQuadratures(numbers1); // nothrow
        getSingularQuadratures(numbers2); // nothrow
    }

    @Test
    @DisplayName("Function getListStartingWithLetterAndSort - CORRECT TEST")
    public void getListStartingWithLetterAndSortCorrect() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Mom");stringList.add("Mishka");
        stringList.add("mumia");stringList.add("Mother");
        stringList.add("mother");stringList.add("Brother");
        stringList.add("Murder");stringList.add("mistake");

        Assertions.assertEquals(
                getListStartingWithLetterAndSort('m', stringList).toString(),
        "[mistake, mother, mumia]");

        Assertions.assertEquals(
                getListStartingWithLetterAndSort('M', stringList).toString(),
        "[Mishka, Mom, Mother, Murder]");

    }

    @Test
    @DisplayName("Function getListStartingWithLetterAndSort - INCORRECT TEST")
    public void getListStartingWithLetterAndSortIncorrect() {
        List<String> stringList;
        stringList = new ArrayList<>();

        getListStartingWithLetterAndSort('a', stringList); // nothrow

        stringList.add("*a");stringList.add("*b");
        stringList.add("*c");stringList.add("cot");
        stringList.add("cat");stringList.add("cit");

        Assertions.assertNull(getListStartingWithLetterAndSort('*', stringList));

        getListStartingWithLetterAndSort('a', null); // nothrow


    }

    @Test
    @DisplayName("Function getLastElementOrElseThrow - CORRECT TEST")
    public void getLastElementOrElseThrowCorrect() {
        Collection<Integer> integerCollection1 = infiniteStream.limit(20).collect(Collectors.toList());
        Collection<Integer> integerCollection2 = infiniteZeroes.limit(20).collect(Collectors.toList());

        Assertions.assertEquals(
                getLastElementOrElseThrow(integerCollection1),
                20);

        Assertions.assertEquals(
                getLastElementOrElseThrow(integerCollection2),
                0);
    }

    @Test
    @DisplayName("Function getLastElementOrElseThrow - INCORRECT TEST")
    public void getLastElementOrElseThrowIncorrect() {
        Collection<Integer> integerCollection = new ArrayList<>();

        Throwable throwable = catchThrowable(()-> getLastElementOrElseThrow(integerCollection));
        assertThat(throwable).isInstanceOf(NoSuchElementException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Function getCountableSumOrElseNull - INCORRECT TEST")
    public void getCountableSumOrElseNullCorrect() {
        int[] numbers1 = new int[]{
                1,2,3,4,5,6,7,8,9,10
        };

        int[] numbers2 = new int[]{
                -1,-2,-3,-4,-5,-6,-7,-8,-9,-10
        };

        int[] numbers3 = new int[]{
                -1,-3,-5,7,-9,11
        };

        int[] numbers4 = new int[]{
                0,0,0,0,0
        };

        int[] numbers5 = new int[5];

        int[] numbers6 = null;

        Assertions.assertEquals(getCountableSumOrElseNull(numbers1),30);
        Assertions.assertEquals(getCountableSumOrElseNull(numbers2),-30);
        Assertions.assertEquals(getCountableSumOrElseNull(numbers3),0);
        Assertions.assertEquals(getCountableSumOrElseNull(numbers4),0);
        Assertions.assertEquals(getCountableSumOrElseNull(numbers5),0);
        Assertions.assertEquals(getCountableSumOrElseNull(numbers6),0);
    }

    @Test
    @DisplayName("Function getMapWhereFirstLatterIsKey - CORRECT TEST")
    public void getMapWhereFirstLatterIsKeyCorrect() {
        List<String> stringList = new ArrayList<>();
        stringList.add("");
        Map<Character, List<String>> karta = getMapWhereFirstLatterIsKey(stringList);

    }

    @Test
    @DisplayName("Function getMapWhereFirstLatterIsKey - INCORRECT TEST")
    public void getMapWhereFirstLatterIsKeyIncorrect() {
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = null;
        Assertions.assertNull(getMapWhereFirstLatterIsKey(stringList1));
        Assertions.assertNull(getMapWhereFirstLatterIsKey(stringList2));

        List<String> stringList3 = new ArrayList<>();
        stringList3.add("");
        Map<Character, List<String>> karta = getMapWhereFirstLatterIsKey(stringList3);
        System.out.println(karta);
    }

}
