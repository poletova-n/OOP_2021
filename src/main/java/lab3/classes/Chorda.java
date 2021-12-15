package lab3.classes;

import lab3.Deep;

@Deep(deep = 1)
public class Chorda extends Animals{
    protected String countOfCervicalVertebras;
    protected String fedWithMilk;
    public Chorda(String name) {
        super(name);
        skeleton = true;
    }

    @Override
    public String toString() {
        return "Chorda ->"+name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() + "\n"+
                "Skeleton -> "+ skeleton;
    }
}
