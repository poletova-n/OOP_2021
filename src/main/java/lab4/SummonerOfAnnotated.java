package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SummonerOfAnnotated {
    private Class<?> testClass;

    SummonerOfAnnotated(String name) {
        try {
            testClass = Class.forName(name);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startSummoning() {
        PrivatMethodsClass temp = new PrivatMethodsClass();
        for (Method method: testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CallNTimes.class)) {
                for (int i = method.getAnnotation(CallNTimes.class).value(); i != 0; i--) {
                    try {
                        method.setAccessible(true);
                        System.out.print(i + ")");
                        method.invoke(temp);
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
