package lab3;

public class Queue<T extends Animal> {

    private int maxSize = 100; // максимальное количество элементов в очереди
        private int count;  // текущее количество элементов в очереди
        private Node<T> pointRead;
        private Node<T> pointAdd;


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



    public Queue() {
            count = 0;
            pointAdd = null;
            pointRead = null;
        }

        public Queue(int maxSize) {
            this.maxSize = maxSize;
            count = 0;
            pointAdd = null;
            pointRead = null;
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
            this.pointAdd.next=new Node<>(elem,null);
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

        public static Queue<? extends Animal> produce(int maxSize) {
            Queue<Vertebrat> Box = new Queue<>(maxSize);
            Queue <? extends Animal> Box2= new Queue<>(maxSize);
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
                            Box.add(new BabyPolarBear());
                        } else {
                            Box.add(new BabyGrizli());
                        }
                        break;
                    case (2):
                        if (i / temp > 7) {
                            Box.add(new WildCat());
                        } else {
                            Box.add(new PolarBear());
                        }
                        break;
                    case (3):
                        if (i / temp > 6) {
                            Box.add(new Cat());
                        } else {
                            Box.add(new Grizli());
                        }
                        break;
                    case (4):
                        if (i / temp > 5) {
                            Box.add(new BabyGrizli());
                        } else {
                            Box.add(new WildCat());
                        }
                        break;
                    case (5):
                        if (i / temp > 2) {
                            Box.add(new BabyPolarBear());
                        } else {
                            Box.add(new Tiger());
                        }
                        break;
                    case (6):
                        if (i / temp > 2) {
                            Box.add(new BigCat());
                        } else {
                            Box.add(new BabyPolarBear());
                        }
                        break;
                    case (7):
                        if (i / temp > 2) {
                            Box.add(new SmallCat());
                        } else {
                            Box.add(new Bear());
                        }
                        break;
                    case (8):
                        if (i / temp > 2) {
                            Box.add(new Tiger());
                        } else {
                            Box.add(new PolarBear());
                        }
                        break;
                    case (9):
                        if (i / temp > 2) {
                            Box.add(new Grizli());
                        } else {
                            Box.add(new BabyGrizli());
                        }
                        break;
                }
            }
            return Box2=Box;
        }



    public static void consume(Queue <?> Box) {
            Queue<? super WildCat> catsBox = new Queue<WildCat>(Box.maxSize);
            Queue<? super BabyPolarBear> bearBox= new Queue<BabyPolarBear>(Box.maxSize);
            Queue<Cat> catsBox2 = new Queue<>(Box.maxSize);
            Queue<Bear> bearBox2= new Queue<>(Box.maxSize);

            for (int i = 0; i < Box.maxSize; i++) {
                if (Box.top() instanceof Cat || Box.top() instanceof Tiger || Box.top() instanceof WildCat) {
                    catsBox2.add((Cat) Box.get());
                } else if (Box.top() instanceof Bear || Box.top() instanceof BabyPolarBear
                        || Box.top() instanceof BabyGrizli || Box.top() instanceof Grizli
                        || Box.top() instanceof PolarBear) {
                    bearBox2.add((Bear) Box.get());
                }
            }

            catsBox=catsBox2;
            bearBox=bearBox2;

            System.out.println("Box with cats");
            catsBox.printQueue();
            System.out.println("Box with bears");
            bearBox.printQueue();

        }
    }

