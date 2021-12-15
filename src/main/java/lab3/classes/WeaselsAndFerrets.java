package lab3.classes;

import lab3.Deep;

@Deep(deep = 5)
public class WeaselsAndFerrets extends Mustelidae {
    protected String type;
    public WeaselsAndFerrets(String name, String size) {
        super(name, size);
        growthOfGenus = "11-56 cm";
    }

    @Override
    public String toString() {
        return "Weasels And ferrets -> " + name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() + "\n"
                +"Aproximately groth of genus -> " + growthOfGenus;
    }
}
