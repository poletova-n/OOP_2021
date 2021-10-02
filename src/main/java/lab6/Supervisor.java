package lab6;

public class Supervisor implements Runnable{

    AbstractProgram ap;
    Thread t;

    Supervisor(AbstractProgram task) {
        ap = task;
    }

    @Override
    public void run() {
        t = new Thread(ap);
        t.start();

        while (ap.getCurrentState() != AbstractProgram.State.FATAL_ERROR) {
            if (ap.getCurrentState() == AbstractProgram.State.UNKNOWN
                || ap.getCurrentState() == AbstractProgram.State.STOPPING) {
                start();
            }
        }

        t.interrupt();

    }


    private void start() {
        ap.setCurrentState(AbstractProgram.State.RUNNING);
    }

    private void stop() {
        ap.setCurrentState(AbstractProgram.State.STOPPING);
    }

}
