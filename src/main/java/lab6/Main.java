package lab6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("==START==");
        Supervisor supervisor = new Supervisor(new RandomCondition(0));
        supervisor.start();
        //Supervisor supervisor1 = new Supervisor(new RandomCondition(1));
        //supervisor1.start();
        //ExecutorService pull = Executors.newFixedThreadPool(4);
        //for (int i = 0; i < 0; i++) {
        //    pull.submit(new Supervisor(new RandomCondition(i)));
        //}
        //pull.shutdown();
    }
}
