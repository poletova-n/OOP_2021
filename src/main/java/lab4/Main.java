package lab4;

import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws Exception{
        Method[] methods = Hero.class.getDeclaredMethods();
        Hero hero = new Hero();

        for (Method method : methods) {
            if(method.isAnnotationPresent(HeroControl.class)){
                method.setAccessible(true);
                int amount = method.getAnnotation(HeroControl.class).times();
                while (amount > 0) {
                    method.invoke(hero);
                    amount--;
                }
            }
        }
    }
}