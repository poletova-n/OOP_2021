package lab6;

import lombok.SneakyThrows;

public class SuperVisor extends Thread{
    private final AbstractProgram app;

    public SuperVisor(AbstractProgram app) {
        this.app = app;
    }

    @SneakyThrows
    @Override
    public void run() {
        this.app.start();
        System.out.println(this.app.getCurrentID() + " start working");
        while (true) {
            synchronized (this.app) {
                Thread.sleep(50);
                if (this.app.getStateMy() == AbstractProgram.State.UNKNOWN ||
                        this.app.getStateMy() == AbstractProgram.State.STOPPING) {
                    System.out.println(this.app.getCurrentID() + " unknown or stopping");
                    this.app.setState(AbstractProgram.State.RUNNING);
                }
                else if (this.app.getStateMy() == AbstractProgram.State.FATAL_ERROR) {
                    System.out.println((this.app.getCurrentID() + " fatal error"));
                    System.exit(0);
                }
                else {
                    System.out.println(this.app.getCurrentID() + " working");
                }
                this.app.notify();
                Thread.sleep(50);
            }
        }
    }
}