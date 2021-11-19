package lab6;

import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Runnable {

    public enum Conditions {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    Conditions cond = Conditions.RUNNING;

    public Conditions getCond() {
        return cond;
    }

    public void setCond(Conditions cond) {
        this.cond = cond;
        System.out.println(this.cond);
    }

    @Override
    public void run() {
        Thread deamon = new Thread(()->{
            while (!Thread.interrupted()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setCond(Conditions.class
                        .getEnumConstants()[ThreadLocalRandom.current().nextInt(Conditions.values().length)]);

                synchronized (this) {
                    if (getCond() != Conditions.RUNNING) {
                        try {
                            wait();
                        }catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }
        });

        deamon.setDaemon(true);
        deamon.start();
        while (!Thread.interrupted()){
            synchronized (this) {
                if (getCond() == Conditions.RUNNING) {
                    notify();
                }
            }
        }
    }

}
