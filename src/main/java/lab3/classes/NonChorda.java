package lab3.classes;

public class NonChorda extends Animals{
    public NonChorda(String name) {
        super(name);
        skeleton = false;
    }

    @Override
    public String toString() {
        return "NonChorda ->"+name;
    }

    @Override
    public String getCharacteristic() {
        return super.getCharacteristic() + "\n"+
                "Skeleton -> "+ skeleton;
    }
}
