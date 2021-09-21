package lab3.animals.classification.cats;

import lab3.animals.classification.cats.Amphibian;

public class Tailless extends Amphibian {
    public Tailless(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Tailless " + name;
    }

}
