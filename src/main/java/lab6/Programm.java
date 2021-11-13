package lab6;

import java.util.concurrent.ThreadLocalRandom;

public class Programm implements Runnable{

    Status currentstatus = Status.RUNNING;

    public enum Status{
        UNKNOWN, STOPPING, RUNNING, FATAL_ERROR
    }

    public Status getCurrentstatus(){
        return  currentstatus;
    }

    public void setCurrentstatus(Status status){
        currentstatus = status;
        System.out.println("Current status is:"+currentstatus);
    }

    @Override
    public void run() {
        Thread t = new Thread(()->{
            while (!Thread.interrupted()){
                //Thread.sleep(1000);
                Utils.pause(1000);
                int rand = ThreadLocalRandom.current().nextInt(Status.values().length);
                setCurrentstatus(Status.class.getEnumConstants()[rand]);
            }
        });
        t.setDaemon(true);
        t.start();
        while (!Thread.interrupted()){
            try {
            synchronized (this) {
                if (getCurrentstatus() == Status.STOPPING || getCurrentstatus() == Status.UNKNOWN) {
                    t.wait();
                }
                if (getCurrentstatus() == Status.RUNNING) {
                    notify();
                }
            }
            }catch (InterruptedException e) {
                e.printStackTrace();
                t.interrupt();
            }
        }
    }
}