package lab3.animals.classification;

public class Feline extends Predatory {
    public Feline(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Feline " + name;
    }
}
