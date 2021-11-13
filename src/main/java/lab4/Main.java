package lab4;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Example example = new Example();
        Class<?> test = example.getClass();
        for(Method method: test.getDeclaredMethods()){
            System.out.print("check ");
            if(method.isAnnotationPresent(Annotation.class)){
                for (int i = method.getAnnotation(Annotation.class).value(); i!=0;i--){
                    if(method.isAnnotationPresent(Annotation.class)) {
                        method.setAccessible(true);
                        System.out.print(i + " ");
                        method.invoke(example);
                    }
                }
            }
        }
    }
}
