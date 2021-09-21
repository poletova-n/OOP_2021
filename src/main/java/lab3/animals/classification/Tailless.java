package lab3.animals.classification;

public class Tailless extends Amphibian {
    public Tailless(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Tailless " + name;
    }
}
