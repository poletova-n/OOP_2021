import animal.hierarchy.Animal;
import animal.hierarchy.SiberianFrog;

import java.lang.reflect.InvocationTargetException;

public class Functions {

    public static  <T extends Animal> Queue<Animal> produce(Class<T> upperBound) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Queue<Animal> result = new Queue<>();

        for (Class<? super SiberianFrog> i = SiberianFrog.class; i != upperBound.getSuperclass(); i = i.getSuperclass()) {
            result.add((T)i.getConstructor().newInstance());
        }
        return result;
    }

    public static  <T extends Animal> Queue<Animal> consume(Queue<T> origin, Class<? extends T> lowerBound) {
        Queue<Animal> result = new Queue<>();

        while (!origin.isEmpty()) {
            T temp = origin.get();
            if (!lowerBound.isInstance(temp) || (temp.getClass().equals(lowerBound))) {
                result.add(temp);
            }
        }
        return result;
    }
}
