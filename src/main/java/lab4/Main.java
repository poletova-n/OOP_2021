package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Employee employee = new Employee("John", 10_000);
        callDeclaredMethods(employee);
    }

    public static void callDeclaredMethods(Employee e) throws InvocationTargetException, IllegalAccessException {
        for (Method m : e.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(HowMuchHowMany.class)) {

                m.setAccessible(true);
                int number = m.getAnnotation(HowMuchHowMany.class).value();

                for (int i = 0; i < number; i++) {
                    if (m.getReturnType().equals(Void.TYPE)) {
                        if (m.getParameterCount() < 1) {
                            m.invoke(e);
                        } else {
                            m.invoke(e, (Object) new String[]{"make dinner", "to wash the dishes", "wash the floor", "to steel eggs"});
                        }
                    } else if (m.getReturnType().equals(Double.TYPE)) {
                        System.out.println(m.invoke(e, 10));
                    } else {
                        System.out.println(m.invoke(e));
                    }
                }
                System.out.println("----------------");
            }
        }
    }
}