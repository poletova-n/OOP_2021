package lab4;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main  {

    public static void main(String[] args) {
        Cat cat = new Cat();

        Class<?> classInstance = cat.getClass();

        for (Method m : classInstance.getDeclaredMethods())
        {
            if (m.isAnnotationPresent(RemoteControl.class)) {
                RemoteControl rc = m.getAnnotation(RemoteControl.class);
                int it = rc.times();

                while (it > 0) {
                    try {
                        m.setAccessible(true);
                        m.invoke(cat);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                     }
                    it--;
                }

            }

        }

    }
}
