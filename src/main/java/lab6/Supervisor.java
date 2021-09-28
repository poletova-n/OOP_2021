package lab6;

public class Supervisor implements Runnable{

    AbstractProgram as;
    Thread t;

    Supervisor(AbstractProgram task) {
        as = task;
    }

    @Override
    public void run() {
        t = new Thread(as);
        t.start();

        while (as.getCurrentState() != AbstractProgram.State.FATAL_ERROR) {
            if (as.getCurrentState() == AbstractProgram.State.UNKNOWN
                || as.getCurrentState() == AbstractProgram.State.STOPPING) {
                start();
            }
        }

        t.interrupt();

    }


    private void start() {
        as.setCurrentState(AbstractProgram.State.RUNNING);
    }

    private void stop() {
        as.setCurrentState(AbstractProgram.State.STOPPING);
    }

}
