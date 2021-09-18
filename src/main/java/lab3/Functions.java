package lab3;

import lab3.animals.classification.*;

public class Functions {

    public static Queue<? extends Chorda> produce() {
        Queue<? extends Chorda> queue = new Queue();

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

    public static void consume(Queue<? extends Chorda> queue) throws QueueUnderFlow {
        Queue<? super Cat> cats = new Queue();
        Queue<? super Bombinatoridae> bombinatoridaes = new Queue();
        Queue<? super Dartfrog> dartfrogs = new Queue();

        while (!queue.isEmpty()) {
            if (queue.get() instanceof Cat) {
                cats.add(queue.pop());
            } else if (queue.get() instanceof Bombinatoridae) {
                bombinatoridaes.add(queue.pop());
            } else if (queue.get() instanceof Dartfrog) {
                dartfrogs.add(queue.pop());
            }
        }

        System.out.println(cats);
        System.out.println(bombinatoridaes);
        System.out.println(dartfrogs);
    }

}