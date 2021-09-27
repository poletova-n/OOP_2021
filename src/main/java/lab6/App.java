package lab6;

import java.util.Random;

public class App {
    public enum StateOfTask {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }
    private final String name;
    private volatile StateOfTask state;
    private final int millies;
    private final Thread task = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (!task.isInterrupted()) {
                        try {
                            this.wait(millies);
                            setState(getRandomState());
                        } catch (InterruptedException e) {
                            state = StateOfTask.STOPPING;
                        }
                    } else
                        state = StateOfTask.STOPPING;
                    this.notify();
                }
            }
        }

        private StateOfTask getRandomState() {
            StateOfTask state;
            Random random = new Random();
            switch ((random.nextInt(4) - 1 )) {
                case 0:
                    state = StateOfTask.UNKNOWN;
                    break;
                case 1 :
                    state = StateOfTask.STOPPING;
                    break;
                case 2 :
                    state = StateOfTask.RUNNING;
                    break;
                default :
                    state = StateOfTask.FATAL_ERROR;
                    break;
            }
            return state;
        }
    });

    public App(String name, int millies) {
        this.name = name;
        this.millies = millies;
        task.setName(name);
        task.setDaemon(true);
    }

    public int getMillies() {
        return millies;
    }
    public Thread getTask() {
        return task;
    }
    public String getName() {
        return name;
    }
    public synchronized StateOfTask getState() {
        return state;
    }
    public synchronized void setState(StateOfTask state) {
        this.state = state;
    }
}
