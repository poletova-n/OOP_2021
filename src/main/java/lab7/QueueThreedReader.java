package lab7;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueThreedReader implements Runnable {
    private LinkedBlockingQueue<String> queue;

    private String identificator;

    private String scenarioNumber;

    public QueueThreedReader(LinkedBlockingQueue<String> queue,Integer code, String scenarioNumber){
        identificator = scenariousType.ANSII_RED + "QueueThreedReader <-> "+ Integer.toString(code) + scenariousType.ASII_DEFAULT;
        this.queue = queue;
        this.scenarioNumber = scenarioNumber;
    }

    public void run(){
        while (queue.isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("In scenario "+scenarioNumber + " with identificator"+identificator+ " start reading and get " + queue.poll());
    }
}
