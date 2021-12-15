package lab7;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Integer N =  Integer.parseInt(args[0]);
        ExecutorService pull = Executors.newFixedThreadPool(N * 2);
        //get annotation of scenario
        Scenarious scenarious = new Scenarious();
        String start  = scenarious.getClass().getMethod("first", Integer.class).getAnnotation(scenariousType.class).start();
        String end = scenarious.getClass().getMethod("first", Integer.class).getAnnotation(scenariousType.class).end();
        String first = scenarious.getClass().getMethod("first", Integer.class).getAnnotation(scenariousType.class).number();
        String second = scenarious.getClass().getMethod("second", Integer.class).getAnnotation(scenariousType.class).number();
        String third = scenarious.getClass().getMethod("third", Integer.class).getAnnotation(scenariousType.class).number();
        //
        //System.out.println(start + first);
        Scenarious.first(N);
        //System.out.println(end + first);
        //System.out.println(start + second);
        Scenarious.second(N);
        //System.out.println(end + second);
        //System.out.println(start + third);
        Scenarious.third(N);
        //System.out.println(end + third);
    }
}
