import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        MyClass object = new MyClass();
        Class<?> c = object.getClass();
        analyze(c, object);
    }

    public static void analyze(Class<?> source, MyClass obj) throws Exception {
        Method[] methods = source.getDeclaredMethods();

        for (Method method : methods) {
            if (!method.isAnnotationPresent(MyAnnotation.class)) {
                continue;
            }
            method.setAccessible(true);
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            if (annotation != null) {
                int count = annotation.value();
                for (int i = 0; i < count; ++i) {
                    method.invoke(obj);
                }
            }
        }
    }
}
