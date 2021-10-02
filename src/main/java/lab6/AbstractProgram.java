package lab6;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractProgram implements Runnable {

    public enum State {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private State currentState = State.RUNNING;
    private ReentrantLock lock = new ReentrantLock();
    private int frequency = 1000;


    AbstractProgram() {
    }

    AbstractProgram(int millis) {
        frequency = millis;
    }


    public State getCurrentState() {
        lock.lock();
        try {
            return currentState;
        } finally {
            lock.unlock();
        }
    }

    public void setCurrentState(State state) {
        lock.lock();
        try {
            currentState = state;
            System.out.println("Current state is: " + currentState);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {



        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(frequency);
                } catch (InterruptedException e) {
                    break;
                }
                int rand = ThreadLocalRandom.current().nextInt(State.values().length);
                setCurrentState(State.class.getEnumConstants()[rand]);
            }

        }
        );

        t.setDaemon(true);
        t.start();


        while (!Thread.interrupted()) {
            try {
                synchronized (this) {
                    if (getCurrentState() == State.STOPPING
                            || getCurrentState() == State.UNKNOWN) {
                        wait();
                    }
                    if (getCurrentState() == State.RUNNING) {
                        notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Abstract program has been stopped");
                t.interrupt();
                e.printStackTrace();
            }
        }





    }
}
