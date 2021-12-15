package lab3.classes;

import lab3.Deep;

@Deep(deep = 2)
public class Mammals extends Chorda{
    protected boolean predator;
    public Mammals(String name) {
        super(name);
        countOfCervicalVertebras = "7";
        fedWithMilk = "true";
    }

    @Override
    public String toString() {
        return "Mammal -> " + name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() + "\n"+
                "Fed with milk -> "+ fedWithMilk +"\n"+
                "Count of cervical vertebras -> "+countOfCervicalVertebras;
    }
}
