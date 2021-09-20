package lab3.animals.classification.cats;

import lab3.animals.classification.cats.Cat;

public final class DomesticCat extends Cat {
    public DomesticCat(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "DomesticCat " + name;
    }
}
