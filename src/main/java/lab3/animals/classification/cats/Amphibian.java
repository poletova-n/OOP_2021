package lab3.animals.classification.cats;


public class Amphibian extends Chorda {
    public Amphibian(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Amphibian " + name;
    }
}