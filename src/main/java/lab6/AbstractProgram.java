package lab6;

import lombok.SneakyThrows;

public class AbstractProgram extends Thread {

    public enum State {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private final String currentID;
    private State state;

    public AbstractProgram(int number) {
        buildState(getRandom());
        currentID = ("Abstract program ") + number +(" in a state of");
    }

    private int getRandom() {
        return ((int) (Math.random() * 4) + 1);
    }

    private void rebuildState() {
        buildState(getRandom());
    }

    private void buildState(int integer) {
        if (integer ==1 ) {
            state = State.UNKNOWN;
        }
        else if (integer ==2 ) {
            state = State.STOPPING;
        }
        else if (integer ==3 ) {
            state = State.RUNNING;
        }
        else if (integer ==4 ) {
            state = State.FATAL_ERROR;
        }
        else {
            throw new IllegalStateException("unexpected value: " + integer);
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getStateMy() {
        return state;
    }

    public String getCurrentID() {
        return currentID;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                System.out.println(("Rebuild state " + currentID));
                rebuildState();
                this.wait();
            }
        }
    }
}
