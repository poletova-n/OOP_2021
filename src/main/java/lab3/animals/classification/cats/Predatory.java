package lab3.animals.classification.cats;

public class Predatory extends Mammals {
    public Predatory(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Predatory " + name;
    }
}
