package lab6;

import lombok.SneakyThrows;

public class AbstractCondition extends Thread {

    public enum Condition {
        UNKNOWN,
        RUNNING,
        FATAL_ERROR
    }

    private final String currentID;
    private Condition condition;

    public AbstractCondition(int number) {
        buildCondition(getRandom());
        currentID = ("RandomConditionThread --> NUMBER == ") + number;
    }

    private int getRandom() {
        return ((int) (Math.random() * 3) + 1);
    }

    private void rebuildCondition() {
        buildCondition(getRandom());
    }

    private void buildCondition(int integer) {
        switch (integer) {
            case 1 -> condition = Condition.UNKNOWN;
            case 2 -> condition = Condition.RUNNING;
            case 3 -> condition = Condition.FATAL_ERROR;
            default -> throw new IllegalStateException("unexpected value: " + integer);
        }
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getCurrentID() {
        return currentID;
    }


    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                System.out.println(("Rebuild condition " + currentID));
                rebuildCondition();
                this.wait();
            }
        }
    }
}