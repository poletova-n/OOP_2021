package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Run {
    public static void run(Felings felings) throws InvocationTargetException, IllegalAccessException {
        for (Method m : felings.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(About.class)) {

                m.setAccessible(true);
                int number = m.getAnnotation(About.class).count();

                for (int i = 0; i < number; i++) {
                    if (m.getReturnType().equals(Void.TYPE)) {

                        m.invoke(felings);
                    }
                    System.out.println("****");
                }
            }
        }
    }
}
