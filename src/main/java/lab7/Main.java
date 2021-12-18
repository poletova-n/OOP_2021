package lab7;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Scanner in = new Scanner(System.in);
        System.out.println("*********start!**********");
        System.out.println("Enter number of potokov.");

        int N =in.nextInt();

        Thread[] writ = new Thread[N];
        Thread[] read = new Thread[N];

        for (int i = 0; i < N; i++) {
            writ[i] = new Thread(new Writing(queue, "messeng", 100));
            read[i] = new Thread(new Reading(queue, 200));
        }

        for (int i = 0; i < N; i++) {
            writ[i].start();
            read[i].start();
        }

        Thread all = new Thread(() ->
        {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current queue state:" + queue);
            }
        });

        all.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < N; i++) {
            writ[i].stop();
            read[i].stop();
        }
        all.stop();

        System.out.println("*********finish!**********");
    }
}