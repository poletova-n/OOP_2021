package lab3;

import lab3.animals.classification.Chorda;

public class Functions {

    public static <T extends Chorda> Queue<T> produce(){
        return new Queue<T>();
    }

    public static <T extends Chorda> void consume(Queue<T> queue){

    }
}
