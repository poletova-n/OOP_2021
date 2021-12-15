package lab3.classes;

import lab3.Deep;

@Deep(deep = 3)
public class Predators extends Mammals {
    protected String size;

    public Predators(String name) {
        super(name);
        predator = true;
    }

    @Override
    public String toString() {
        return "Predator -> " + name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() + "\n" +
                "Predator -> " + true;
    }
}
