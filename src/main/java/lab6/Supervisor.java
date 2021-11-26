package lab6;

public class Supervisor implements Runnable {
    MyThread thread;

    public Supervisor(MyThread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread t = new Thread(thread);
        t.start();

        synchronized (this) {
            while (thread.getCond() != MyThread.Conditions.FATAL_ERROR) {
                if (thread.getCond() == MyThread.Conditions.UNKNOWN || thread.getCond() == MyThread.Conditions.STOPPING){
                    start();
                }
            }
        }
        stop(t);
    }

    private void start () {
        thread.setCond(MyThread.Conditions.RUNNING);
    }
    private void stop (Thread t) {
        thread.setCond(MyThread.Conditions.STOPPING);
        t.interrupt();
        System.out.println("Thread stopped by Supervisor");
    }
}
