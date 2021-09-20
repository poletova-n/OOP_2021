package lab3.animals.classification.DEPRECATED.frogs;


import lab3.animals.classification.Chorda;

public class Amphibian extends Chorda {
    public Amphibian(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Amphibian " + name;
    }
}