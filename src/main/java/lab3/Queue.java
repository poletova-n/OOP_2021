package lab3;

import lab3.annimals.*;

public class Queue<T extends Chordal> {

    public static class Node<E> {
        E value;
        Node<E> next;

        Node(E val, Node<E> next) {
            this.value = val;
            this.next = next;
        }


        public E getVal()
        {
            return value;
        }

        public Node<E> getNext()
        {
            return next;
        }

    }

    private final int maxSize; // максимальное количество элементов в очереди
    private int count;  // текущее количество элементов в очереди
    private Node<T> pointRead;
    private Node<T> pointAdd;



    public Queue(int size) {
        this.maxSize = size;
        count = 0;
        pointAdd = null;
        pointRead = null;
    }

    public void printQueue() {
        int numb = this.count;
        int i = 1;
        Node<T> elements = new Node<>(this.pointRead.getVal(), this.pointRead.getNext());

        while (numb > 0) {
            System.out.println(i + " " + elements.getVal().getClass());
            i++;
            elements = elements.getNext();
            numb--;
        }
    }

    public void add(T elem) {
        try{
            if (this.count==this.maxSize) {
                throw new StackOverflowError("Queue is overflow!");
            }
            if(pointAdd==null) {
                this.pointAdd = new Node<>(elem, null);
                this.pointRead = this.pointAdd;
            }
            else{
                this.pointAdd.next= new Node<>(elem, null);
                this.pointAdd = this.pointAdd.next;
            }
            this.count++;
        }catch (StackOverflowError ex){
            System.out.println(ex.getMessage());
        }
    }

    public T get() {
        try {
            if (count == 0) {
                throw new IllegalStateException("Impossible to get an element! The queue is empty!\n");
            }
            T temp =  this.pointRead.getVal();
            this.pointRead = this.pointRead.getNext();
            this.count--;
            if (this.pointRead == null) {
                this.pointAdd = null;
            }
            return temp;
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public T top() {
        return  this.pointRead.getVal();
    }

    public static Queue<? extends Chordal> produce(int size) {

        Queue<Vertebrat> Box = new Queue<>(size);
        Queue<? extends Chordal> Box2 = new Queue<>(size);

        for (int i = 0; i < size; i++) {
            int temp = (int) ((Math.random() * 4));
            switch (temp) {
                case (0) -> Box.add(new BengalOwl());
                case (1) -> Box.add(new MagellansOwl());
                case (2) -> Box.add(new SilverGibbon());
                case (3) -> Box.add(new TheWhiteArmedGibbon());
            }
        }
        return Box2 = Box;
    }

    public static void consume(Queue <?> Box){
        Queue<? super Striginae> birdBox = new Queue<Striginae>(Box.maxSize);
        Queue<? super Gibbon> monkebox = new Queue<Gibbon>(Box.maxSize);

        Queue<? super Owls> birdbox2 = new Queue<>(Box.maxSize);
        Queue<? super GreatApes> monkebox2 = new Queue<>(Box.maxSize);

        for (int i = 0; i < Box.maxSize; i++) {
            if (Box.top() instanceof Owls || Box.top() instanceof Striginae || Box.top() instanceof BengalOwl || Box.top() instanceof MagellansOwl) {
                birdbox2.add((Owls) Box.get());
            } else if (Box.top() instanceof GreatApes || Box.top() instanceof Gibbon
                    || Box.top() instanceof SilverGibbon || Box.top() instanceof TheWhiteArmedGibbon) {
                monkebox2.add((GreatApes) Box.get());
            }
        }
        birdBox = birdbox2;
        monkebox = monkebox2;

        System.out.println("Box with birds");
        birdBox.printQueue();
        System.out.println("Box with monkeys");
        monkebox.printQueue();
    }
}