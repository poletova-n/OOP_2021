package lab3;

import lab3.animals.classification.BlueTreeFrog;
import lab3.animals.classification.*;
import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

public class Functions {

    public static Queue<Chorda> produce() throws QueueOverFlow {
        Queue<Chorda> queue = new Queue();

        queue.add(new BlueTreeFrog("Crazy Frog"));
        queue.add(new BlueTreeFrog("kva"));
        queue.add(new BlueTreeFrog("kva kva"));
        queue.add(new ColoringTreeFrog("Tree frogger"));

        queue.add(new DomesticCat("Pice"));
        queue.add(new DomesticCat("Kitty"));
        queue.add(new DomesticCat("Kitten"));
        queue.add(new ForestCat("Big cat"));
        queue.add(new ForestCat("Mrrr..."));

        queue.add(new FarEasternToad("Kvakushka"));
        queue.add(new RedBelliedToad("Lagushka"));

        return queue;
    }

    public static void consume(Queue<Chorda> queue) throws QueueUnderFlow, QueueOverFlow {
        Queue<Cat> cats = new Queue(queue.getSize());
        Queue<Bombinatoridae> bombinatoridaes = new Queue(queue.getSize());
        Queue<Dartfrog> dartfrogs = new Queue(queue.getSize());

        while (!queue.isEmpty()) {
            if (queue.get() instanceof Cat) {
                cats.add((Cat) queue.pop());
            } else if (queue.get() instanceof Bombinatoridae) {
                bombinatoridaes.add((Bombinatoridae) queue.pop());
            } else if (queue.get() instanceof Dartfrog) {
                dartfrogs.add((Dartfrog) queue.pop());
            }
        }

        System.out.println(cats);
        System.out.println(bombinatoridaes);
        System.out.println(dartfrogs);
    }

}