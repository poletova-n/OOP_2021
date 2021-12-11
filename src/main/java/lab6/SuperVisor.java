package lab6;

import lombok.SneakyThrows;

public class SuperVisor extends Thread{
    private final AbstractCondition app;

    public SuperVisor(AbstractCondition app) {
        this.app = app;
    }

    @SneakyThrows
    @Override
    public void run() {
        this.app.start();
        System.out.println(this.app.getCurrentID() + " start working");
        while (true) {
            synchronized (this.app) {
                Thread.sleep(100);
                if (this.app.getCondition() == AbstractCondition.Condition.UNKNOWN ) {
                    System.out.println(this.app.getCurrentID() + " unknown or stopping");
                    this.app.setCondition(AbstractCondition.Condition.RUNNING);
                }
                else if (this.app.getCondition() == AbstractCondition.Condition.FATAL_ERROR) {
                    System.out.println((this.app.getCurrentID() + " fatal error"));
                    System.exit(0);
                }
                else {
                    System.out.println(this.app.getCurrentID() + " working");
                }
                this.app.notify();
                Thread.sleep(100);
            }
        }
    }
}