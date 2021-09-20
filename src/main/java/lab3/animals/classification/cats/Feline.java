package lab3.animals.classification.cats;

public class Feline extends Predatory {
    public Feline(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Feline " + name;
    }
}
