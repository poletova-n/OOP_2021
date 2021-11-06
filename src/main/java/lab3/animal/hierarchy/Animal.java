package animal.hierarchy;

public class Animal {
    public Animal() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
