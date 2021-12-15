package lab3.classes;

import lab3.Deep;

@Deep(deep = 4)
public class Mustelidae extends Predators{
    protected String growthOfGenus;
    public Mustelidae(String name, String size) {
        super(name);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Mustelidae -> " + name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() +"\n"+
                "Size -> " + size;
    }
}
