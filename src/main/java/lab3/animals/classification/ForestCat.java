package lab3.animals.classification;

public final class ForestCat extends Cat {
    public ForestCat(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "ForestCat " + name;
    }
}
