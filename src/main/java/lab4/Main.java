package lab4;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception{
        Method[] methods = ExampleClass.class.getDeclaredMethods();
        ExampleClass exampleClass = new ExampleClass();

        for (int i = 0; i < methods.length; i++){
            methods[i].setAccessible(true);
            int amount = methods[i].getAnnotation(Value.class).data();
            while (amount > 0){
                methods[i].invoke(exampleClass);
                amount--;
            }
        }
    }
}
