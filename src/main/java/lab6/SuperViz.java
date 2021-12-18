package lab6;

public class SuperViz implements Runnable {

    Proga prog;

    public SuperViz(Proga proga) {
        prog = proga;
    }

    @Override
    public void run() {
        Thread thread = new Thread(prog);
        thread.start();

        while (prog.getStatus() != Proga.Status.FATAL_ERROR) {
            if ((prog.getStatus() == Proga.Status.UNKNOWN)
                    || (prog.getStatus() == Proga.Status.STOPPING)) {
                start();
            }
            else if( prog.getStatus() == Proga.Status.RUNNING){

                stop();
            }
        }

        thread.interrupt();
    }


    public void start() {
        prog.setStatus(Proga.Status.RUNNING);
    }

    public void stop() {prog.setStatus(Proga.Status.STOPPING);}
}