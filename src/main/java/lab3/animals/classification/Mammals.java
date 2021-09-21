package lab3.animals.classification;

public class Mammals extends Chorda {
    public Mammals(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Mammals " + name;
    }
}
