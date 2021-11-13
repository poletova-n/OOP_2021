package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public void task1(){
        System.out.println("#1 Task");
        ArrayList<Integer> numlist = new ArrayList<>();
        numlist.add(1);
        numlist.add(2);
        numlist.add(3);
        numlist.add(4);
        numlist.add(5);
        numlist.add(6);
        numlist.stream().mapToInt(n->n).average().stream().forEach(System.out::println);
    }

    public void task2(){
        System.out.println("#2 Task");
        ArrayList<String> stringlist = new ArrayList<>();
        stringlist.add("qwerty");
        stringlist.add("asdfgh");
        stringlist.add("zxcvbn");
        stringlist.add("poiuytr");
        stringlist.add("lkjh");
        //stringlist.stream().map(n->n.toUpperCase()).forEach(System.out::println);
        stringlist.stream().map(n->"_new_"+n.toUpperCase()).forEach(System.out::println);
    }

    public void task3(){
        System.out.println("#3 Task");
        ArrayList<Integer> numlist = new ArrayList<>();
        numlist.add(1);
        numlist.add(2);
        numlist.add(3);
        numlist.add(3);
        numlist.add(4);
        numlist.add(4);
        //numlist.stream().distinct().map(n->n*n).forEach(System.out::println);
        numlist.stream()
                .collect(Collectors.groupingBy(Function.identity()
                        ,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n->n.getValue()==1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    public void task4(char symbol){
        System.out.println("#4 Task");
        Collection<String> stringlist = new ArrayList<>();
        stringlist.add("qwerty");
        stringlist.add("asdfgh");
        stringlist.add("zxcvbn");
        stringlist.add("poiuytr");
        stringlist.add("lkjh");
        stringlist.stream().filter(n->n.charAt(0)>symbol).sorted().forEach(System.out::println);
    }

    public <T> T task5(){
        System.out.println("#5 Task");
        ArrayList<Integer> numlist = new ArrayList<>();
        numlist.add(1);
        numlist.add(2);
        numlist.add(3);
        numlist.add(3);
        numlist.add(4);
        numlist.add(7);
        return (T) numlist.stream()
                .skip(numlist.size()-1)
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }

    public int task6(){
        System.out.println("#6 Task");
        int[] array = {1,2,3,4,5,6,7,8,9};
        return Arrays.stream(array).filter(n->n%2==0).reduce((s1,s2)->s1+s2).orElse(0);
    }

    public Map<Character,String> task7(){
        System.out.println("#7 Task");
        ArrayList<String> stringlist = new ArrayList<>();
        stringlist.add("qwerty");
        stringlist.add("asdfgh");
        stringlist.add("zxcvbn");
        stringlist.add("poiuytr");
        stringlist.add("lkjh");
        return stringlist.stream()
                .filter(n-> n.length()>=2)
                .collect(Collectors.toMap(
                        s->s.charAt(0)
                        ,s->s.substring(1)));
    }

    public static void main(String[] args) {
        try {
            Main methods = new Main();
            methods.task1();
            methods.task2();
            methods.task3();
            methods.task4('a');
            System.out.println((int) methods.task5());
            //methods.task5();
            System.out.println(methods.task6());
            System.out.println(methods.task7());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
