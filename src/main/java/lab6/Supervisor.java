package lab6;

public class Supervisor extends Thread {

    private static final String STARTING = "Starting application";
    private static final String STOPPING = "Stopping application";
    private static final String RESTARTING = "Restarting application:";

    private final App app;

    public Supervisor(App app){
        super();
        this.app = app;
        app.getTask().start();
    }
    public String getNameOfApp() {
        return app.getName();
    }

    private void startApp() {
        synchronized (app) {
            System.out.println(STARTING);
            app.setState(App.StateOfTask.RUNNING);
            System.out.println("{status} = " + app.getState());
        }
    }
    private void stopApp() {
        synchronized (app) {
            System.out.println(STOPPING);
            app.setState(App.StateOfTask.STOPPING);
            System.out.println("{status} = " + app.getState());
        }
    }
    private void restartApp() {
        synchronized (app) {
            System.out.println(RESTARTING);
            stopApp();
            startApp();
        }
    }

    @Override
    public void run() {
        startApp();
        while (!app.getTask().isInterrupted()) {
            synchronized (app) {
                System.out.println("       {status} = " + app.getState());
                if (app.getState() == App.StateOfTask.UNKNOWN || app.getState() == App.StateOfTask.STOPPING) {
                    restartApp();
                    try {
                        app.wait(app.getMillies());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else if (app.getState() == App.StateOfTask.RUNNING) {
                    try {
                        app.wait(app.getMillies());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else if (app.getState() == App.StateOfTask.FATAL_ERROR) {
                    app.getTask().interrupt();
                }
            }
        }
        stopApp();
    }
}
