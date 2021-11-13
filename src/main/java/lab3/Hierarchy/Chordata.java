package lab3.Hierarchy;

public abstract class Chordata{
    String name;
    public Chordata(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}