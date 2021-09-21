package lab3.animals.classification.cats;

import lab3.animals.classification.cats.Dartfrog;

public class TreeFrog extends Dartfrog {
    public TreeFrog(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "TreeFrog " + name;
    }
}
