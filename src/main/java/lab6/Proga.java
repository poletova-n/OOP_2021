package lab6;

public class Proga extends Thread implements Runnable {

    public enum Status {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR;
    }

    private Status current = Status.RUNNING;

    public void setStatus(Status status) {
            current = status;
            System.out.println("Current status : " + current);
    }

    public Status getStatus() {
            return current;
    }

    @Override
    public void run() {

            while (current.equals(Status.UNKNOWN)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

           int temp = (int) ((Math.random() * 4)+3);

            switch (temp % 4) {
                case (0):
                    current = Status.UNKNOWN;
                    break;
                case (1):
                    current = Status.STOPPING;
                    break;
                case (2):
                    current = Status.RUNNING;
                    break;
                case (3):
                    current = Status.FATAL_ERROR;
                    break;
            }

            Thread thread = new Thread(() -> {
                while (true) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });

        thread.setDaemon(true);
        thread.start();

        while (!Thread.interrupted()) {
            try {
                synchronized (this) {
                    if ((getStatus() == Status.UNKNOWN) || (getStatus() == Status.STOPPING)) {

                        wait();
                    }

                    if ((getStatus() == Status.RUNNING)) {
                        notify();
                    }
                }
            } catch (InterruptedException e) {
               return;
            }
        }
    }
}


