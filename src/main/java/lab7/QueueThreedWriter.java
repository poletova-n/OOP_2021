package lab7;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueThreedWriter implements Runnable{

    private LinkedBlockingQueue<String> queue;
    private String identificator;
    private String scenarioNumber;

    public QueueThreedWriter(LinkedBlockingQueue<String> queue,Integer code , String scenarioNumber){
        identificator = scenariousType.ANSII_RED + "QueueThreedWrite <-> "+ Integer.toString(code) + scenariousType.ASII_DEFAULT;
        this.queue = queue;
        this.scenarioNumber = scenarioNumber;
    }

    public void run(){
        queue.add(identificator);
        System.out.println("In scenario "+scenarioNumber+ " with identificator "+identificator + " start writing");
    }
}
