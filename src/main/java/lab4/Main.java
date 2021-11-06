package lab4;

import java.lang.reflect.*;

public class Main
{
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        try
        {
            Method[] methods = Human.class.getDeclaredMethods();
            Human human = new Human();

            for (int i = 0; i < methods.length; i++)
            {
                if(methods[i].isAnnotationPresent(MyAnnotation.class))
                {
                    methods[i].setAccessible(true);

                    int counter = methods[i].getAnnotation(MyAnnotation.class).param();

                    while (counter > 0)
                    {
                        methods[i].invoke(human);
                        counter--;

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