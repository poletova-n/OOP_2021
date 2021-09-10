package lab3;
import lab3.animals.classification.Chorda;

public class Queue <T extends Chorda> {

    private final Chorda[] elements;

    public Queue(){
        elements = new Chorda[10];
    }
    public Queue(int N) {
        if (N > 0)
            elements = new Chorda[N];
        else
            elements = new Chorda[10];
    }

    public void add(T element) {

    }
    public T get() {
        return null;
    }

}
