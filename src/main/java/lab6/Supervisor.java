package lab6;

public class Supervisor implements  Runnable{
    Programm programm;

    public Supervisor(Programm programm){
        this.programm = programm;
    }

    @Override
    public void run() {
        Thread t = new Thread(programm);
        t.start();

        synchronized (this) {
            while (programm.getCurrentstatus() != Programm.Status.FATAL_ERROR) {
                if (programm.getCurrentstatus() == Programm.Status.UNKNOWN
                        || programm.getCurrentstatus() == Programm.Status.STOPPING) {
                    //System.out.println("Current status is:"+programm.getCurrentstatus());
                    programm.setCurrentstatus(Programm.Status.RUNNING);
                }
            }
        }
        t.interrupt();
    }
}