package lab6;


import lombok.SneakyThrows;

//import ANSII_CODES.*;

public class RandomCondition extends Thread {
    public enum Condition {
        WORKING,
        PARTLY_WORKING,
        BROKEN
    }

    private String identificator;
    private Condition condition;

    public RandomCondition(Integer number) {
        buildCondition(getRandom());
        identificator = ("RandomConditionThread --->> NUMBER == ") + Integer.toString(number);
    }

    private Long getRandom() {
        return Math.round(Math.random() * 1000);
    }

    private void rebuildCondition() {
        buildCondition(getRandom());
    }

    private void buildCondition(Long integer) {
        if (integer % 3 == 0) {
            condition = Condition.WORKING;
        } else if (integer % 2 == 0) {
            condition = Condition.PARTLY_WORKING;
        } else {
            condition = Condition.BROKEN;
        }
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getIdentififcator() {
        return identificator;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("start app");
        synchronized (this) {
            while (true) {
                System.out.println(("Rebuild condition " + identificator));
                rebuildCondition();
                //System.out.println("Wait");
                this.wait();
            }
        }
    }
}
