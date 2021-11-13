package lab3;

public class Queue<T> {
    private int capacity;
    private int size;
    private Node head;
    private Node current;
    private Queue<T> upperBoundGeneric;
    private Queue<? super T> genericQueue [] = new Queue[4];
    private int sizeofconsume = 0;

    private class Node {
        private T value;
        private int num;
        Node next;
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        head = new Node();
        head.next = new Node();
        size = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T ex) {
        if (size == 0) {
            head.value = ex;
            head.num = size;
            current = head;
        } else {
            current.next = new Node();
            current.next.value = ex;
            current.next.num = size;
            current = current.next;
        }
        size++;
    }

    /*public void delete() {
        size--;
        head = head.next;
    }*/

    public T get() {
        Node gett;
        gett = head;
        head = head.next;
        return gett.value;
    }

    public void print() {
        current = head;
        for(int p = size; p != 0; p--){
            //System.out.print(current.num);
            System.out.println(current.value.toString());
            current = current.next;
        }
    }

    public Queue<? extends T>  produce(T example) {
        current = head;
        upperBoundGeneric = new Queue<>(capacity);
        for(int p = 0; p < size; p++) {
            if (example.getClass().isAssignableFrom(current.value.getClass())
                    && (example.getClass() != current.value.getClass())) {
                upperBoundGeneric.add(current.value);
            }
            current = current.next;
        }
        return upperBoundGeneric;
    }

    public Queue<? super T> consume(T example){
        current = head;
        Queue<? super T> lowerBoundGeneric = new Queue<>(size);
        for(int t = 0; t < lowerBoundGeneric.getCapacity(); t++){
            if(current.value.getClass().isAssignableFrom(example.getClass())
                && (current.value.getClass()!=example.getClass())){
                lowerBoundGeneric.add(current.value);
            }
            current = current.next;
        }
        genericQueue[sizeofconsume] = lowerBoundGeneric;
        return genericQueue[sizeofconsume];
    }

    /*public Queue<T> consume(Queue upperBoundGeneric, T lower) {
        Queue lowerBoundGeneric = new Queue(upperBoundGeneric.getCapacity());
        for (int t = 0; t < upperBoundGeneric.getCapacity(); t++){
            if (!lower.getClass().isAssignableFrom(upperBoundGeneric.get().getClass())) {
                upperBoundGeneric.delete();
            } else {
                lowerBoundGeneric.add(lower);
            }
        }
        return lowerBoundGeneric;
    }*/
}
