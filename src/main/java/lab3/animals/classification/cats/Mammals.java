package lab3.animals.classification.cats;

public class Mammals extends Chorda {
    public Mammals(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Mammals " + name;
    }
}
