package lab3.animals.classification;

public class Dartfrog extends Tailless {
    public Dartfrog(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Dartfrog " + name;
    }
}
