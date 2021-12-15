package lab4;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        try {
            Player player = new Player();
            Method[] methods = player.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                methods[i].setAccessible(true);
                for (int i1 = 0; i1 < methods[i].getAnnotation(MyAnotation.class).count(); i1++) {
                    methods[i].invoke(player);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
