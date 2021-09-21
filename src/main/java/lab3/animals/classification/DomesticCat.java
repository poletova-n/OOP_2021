package lab3.animals.classification;

public final class DomesticCat extends Cat {
    public DomesticCat(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "DomesticCat " + name;
    }
}
