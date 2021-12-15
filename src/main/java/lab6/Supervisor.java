package lab6;


import lombok.SneakyThrows;

public class Supervisor extends Thread {
    private final RandomCondition app;

    public Supervisor(RandomCondition app) {
        this.app = app;
    }

    @SneakyThrows
    @Override
    public void run() {
        this.app.start();
        System.out.println(this.app.getIdentififcator() + " start working");
        while (true) {
            synchronized (this.app) {
                Thread.sleep(100);
                if (this.app.getCondition() == RandomCondition.Condition.BROKEN) {
                    System.out.println(this.app.getIdentififcator() + " failed");
                    this.app.setCondition(RandomCondition.Condition.PARTLY_WORKING);
                }
                else if (this.app.getCondition() == RandomCondition.Condition.PARTLY_WORKING){
                    System.out.println((this.app.getIdentififcator() + " partly working"));
                }
                else {
                    System.out.println(this.app.getIdentififcator() + " success");
                }
                this.app.notify();
                Thread.sleep(100);
            }
        }

    }
}
