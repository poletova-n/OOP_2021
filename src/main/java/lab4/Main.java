package lab4;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        try{

            Method[] methods = Function.class.getDeclaredMethods();
            Function function = new Function();

            for (int i = 0; i < methods.length; i++)
            {
                if(methods[i].isAnnotationPresent(Counter.class))
                {
                    methods[i].setAccessible(true);

                    int cnt = methods[i].getAnnotation(Counter.class).Counter();

                    for (;cnt > 0; cnt--)
                    {
                        methods[i].invoke(function);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}