package lab3;

public class Queue<T extends  Animal> {

    private int maxSize=100; // максимальное количество элементов в очереди
    private int count;  // текущее количество элементов в очереди
    private Node<T> pointRead;
    private Node<T> pointAdd;

    static class Node<T> {
        T value;
        Node<T> next;
        Node(T val, Node<T> next) {
            this.value = val;
            this.next = next;
        }
    }

    public void printQueue () {
        int numb=count;
        int i=1;
        Node<T> elements = new Node( this.pointRead.value,this.pointRead.next);

        while (numb>0) {
            System.out.println(i+" "+elements.value.getVois());
            i++;
            elements=elements.next;
            numb--;
        }
    }

    public Queue() {
        count = 0;
        pointAdd=null;
        pointRead=null;
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        count = 0;
        pointAdd=null;
        pointRead=null;
    }

    public void add(T elem) {
        try{
            if (this.count==this.maxSize) {
                throw new StackOverflowError("It is too much, you must stop!");
            }
            if(pointAdd==null) {
                this.pointAdd = new Node<>(elem,null);
                this.pointRead = this.pointAdd;
            }
            else{
            this.pointAdd.next=new Node(elem,null);
            this.pointAdd = this.pointAdd.next;
            }
            this.count++;
    }catch (StackOverflowError ex){
            System.out.println(ex.getMessage());
        }
    }

    public T get() {
        try {
            if (count==0) {
                throw new IllegalStateException("Impossible to get an element! The queue is empty!\n");
            }
            T temp = this.pointRead.value;
            this.pointRead = this.pointRead.next;
            this.count--;
            if (this.pointRead == null) {
                this.pointAdd = null;
            }
            return temp;
        }
        catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public T top (){
        return this.pointRead.value;
    }

    public static Queue <? extends Animal> produce(int maxSize) {
        Queue Box = new Queue(maxSize);
        for (int i = 0; i < maxSize; i++) {
            int temp = (int) ((Math.random() * 9) + 1);
            if (temp == 0) {
                temp = 6;
            }
            switch (i % temp) {
                case (0):
                    if (i / temp > 5) {
                        Box.add(new PolarBear());
                    } else {
                        Box.add(new WildCat());
                    }
                    break;
                case (1):
                    if (i / temp > 2) {
                        Box.add( new BabyPolarBear());
                    } else {
                        Box.add( new BabyGrizli());
                    }
                    break;
                case (2):
                    if (i / temp > 7) {
                        Box.add( new WildCat());
                    } else {
                        Box.add( new PolarBear());
                    }
                    break;
                case (3):
                    if (i / temp > 6) {
                        Box.add( new Cat());
                    } else {
                        Box.add( new Grizli());
                    }
                    break;
                case (4):
                    if (i / temp > 5) {
                        Box.add( new BabyGrizli());
                    } else {
                        Box.add( new WildCat());
                    }
                    break;
                case (5):
                    if (i / temp > 2) {
                        Box.add( new BabyPolarBear());
                    } else {
                        Box.add( new Tiger());
                    }
                    break;
                case (6):
                    if (i / temp > 2) {
                        Box.add( new BigCat());
                    } else {
                        Box.add(new BabyPolarBear());
                    }
                    break;
                case (7):
                    if (i / temp > 2) {
                        Box.add( new SmallCat());
                    } else {
                        Box.add(new Bear());
                    }
                    break;
                case (8):
                    if (i / temp > 2) {
                        Box.add( new Tiger());
                    } else {
                        Box.add(new PolarBear());
                    }
                    break;
                case (9):
                    if (i / temp > 2) {
                        Box.add( new Grizli());
                    } else {
                        Box.add(new BabyGrizli());
                    }
                    break;
            }
        }
   return Box;
    }

    public static Queue <? super WildCat>  consume(Queue Box) {
        Queue<Cat> catsBox = new Queue(Box.maxSize);
        Queue<Bear> bearBox = new Queue(Box.maxSize);

        for (int i = 0; i < Box.maxSize; i++) {
            if (Box.top() instanceof Cat || Box.top() instanceof Tiger || Box.top() instanceof WildCat) {
                catsBox.add((Cat)Box.get());
            } else if (Box.top() instanceof Bear || Box.top() instanceof BabyPolarBear
                    || Box.top() instanceof BabyGrizli || Box.top() instanceof Grizli
                    || Box.top() instanceof PolarBear) {
                bearBox.add((Bear) Box.get());
            }
        }

        System.out.println("Box with cats");
        catsBox.printQueue();
        System.out.println("Box with bears");
        bearBox.printQueue();

        Queue finalBox=new Queue(Box.maxSize);
        while(catsBox.pointRead!=null){
            finalBox.add(catsBox.get());
        }
        while (bearBox.pointRead!=null){
            finalBox.add(bearBox.get());
        }
        return finalBox;
    }
};
