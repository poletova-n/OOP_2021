package lab6;

public class Supervisor implements Runnable
{
    private Application app;
    private Thread thrd;

    private Supervisor(Application application){
        thrd = new Thread(this);
        app = application;
    }

    public static Supervisor createAndStart(Application application){
        Supervisor supervisorThrd = new Supervisor(application);
        supervisorThrd.thrd.start();
        return supervisorThrd;
    }

    @Override
    public void run(){

        System.out.println("\u001B[31m" + "**********Supervisor started application**********");

        startApplication();

        while(app.getStatus() != Application.Status.FATAL_ERROR){

            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\u001B[35m" + "Application status: " + app.getStatus());

        }

        stopApplication();
        System.out.println("\u001B[31m" + "Application finished work with status: \"FATAL_ERROR\"");

    }

    public void startApplication(){
        app.setStatus(Application.Status.RUNNING);
    }

    public void stopApplication() {
        app.interruptWork();
    }

}
