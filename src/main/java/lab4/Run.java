package lab4;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
public class Run {
   Class<?> testClass = Felings.class;

     /blic static void run(Class testClass) {

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(About.class)) {
                try {

                    m.invoke(null);

                } catch (InvocationTargetException | IllegalAccessException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }

    }


    public static void run(Class testClass) {
        for (Method method : testClass.getDeclaredMethods()) {
            method.setAccessible(true);
            About annotation = method.getAnnotation(About.class);
            if (annotation != null) {
                int count = annotation.count();
                for (int i = 0; i < count; i++) {
                    try {
                        method.invoke(Felings.class);
                    } catch (IllegalAccessException |InvocationTargetException  e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}*/

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
