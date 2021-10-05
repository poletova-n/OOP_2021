package lab4;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception{
        Method[] declaredMethods = Physculture.class.getDeclaredMethods();
        Physculture boxing = new Physculture();
        int num = declaredMethods.length;
        for (int i = 0; i < num ; i++) {
            declaredMethods[i].setAccessible(true);
            int amount = declaredMethods[i].getAnnotation(About.class).data();
            while(amount > 0){
                declaredMethods[i].invoke(boxing);
                amount--;
            }
        }
    }
}
