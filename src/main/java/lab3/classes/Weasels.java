package lab3.classes;

import lab3.Deep;

@Deep(deep = 6)
public class Weasels extends WeaselsAndFerrets {
    public Weasels(String name, String size, String type) {
        super(name, size);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weasel -> " + name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() + "\n"+
                "Type -> " + type;
    }
}
