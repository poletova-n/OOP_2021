package lab6;

public class Application implements Runnable{

    public enum Status{
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private Status currentStatus;
    private Thread appThrd;

    Application(){
        currentStatus = Status.UNKNOWN;
        appThrd = new Thread(this,"Application Thread");
    }

    public static lab6.Application createAndStart(){
        lab6.Application applicationThrd = new lab6.Application();
        applicationThrd.appThrd.start();
        return applicationThrd;
    }

    public synchronized void setStatus(Status status){
        currentStatus = status;
    }

    public Status getStatus(){
        return currentStatus;
    }

    public void interruptWork(){
        appThrd.interrupt();
    }

    @Override
    public void run() {

        while (currentStatus.equals(Status.UNKNOWN)){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread deamonThrd = new Thread(() -> {

            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switch ((int) ((Math.random() * 4) + 1)) {
                    case 1 -> currentStatus = Status.UNKNOWN;
                    case 2 -> currentStatus = Status.STOPPING;
                    case 3 -> currentStatus = Status.RUNNING;
                    case 4 -> currentStatus = Status.FATAL_ERROR;
                    default -> throw new IllegalStateException("Unexpected value: " + (int) ((Math.random() * 4) + 1));
                }

            }
        });

        deamonThrd.setDaemon(true);
        deamonThrd.start();

        while(!Thread.interrupted()) {

            try {
                synchronized (this) {
                    if ((getStatus() == Status.UNKNOWN) || (getStatus() == Status.STOPPING))
                    {
                        wait();
                    }

                    if ((getStatus() == Status.RUNNING))
                    {
                        notify();
                    }
                }
            }
            catch (InterruptedException ex){
                return;
            }
        }
    }
}
