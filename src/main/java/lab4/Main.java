package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Method[] methods = LazyStudent.class.getDeclaredMethods();
            LazyStudent student = new LazyStudent();

            for (Method method : methods) {

                if (method.isAnnotationPresent(MyAnnotation.class)){

                    method.setAccessible(true);

                    int count = method.getAnnotation(MyAnnotation.class).count();

                    while (count > 0){

                        method.invoke(student);
                        count--;

                    }

                }
            }
        }
        catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
