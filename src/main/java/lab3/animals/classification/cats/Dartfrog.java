package lab3.animals.classification.cats;

import lab3.animals.classification.cats.Tailless;

public class Dartfrog extends Tailless {
    public Dartfrog(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Dartfrog " + name;
    }
}
