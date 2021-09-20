package lab3.animals.classification.cats;

public class Cat extends Feline {
    public Cat(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Cat " + name;
    }
}
