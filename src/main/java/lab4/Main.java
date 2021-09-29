package lab4;

import java.lang.reflect.*;

public class Main 
{
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		try 
		{
			Method[] methods = Person.class.getDeclaredMethods();
			Person pers = new Person();

			for (int i = 0; i < methods.length; i++)
			{
				if(methods[i].isAnnotationPresent(MyAnnotation.class))
				{
					methods[i].setAccessible(true);

					int counter = methods[i].getAnnotation(MyAnnotation.class).param();
					
					for (;counter > 0; counter--)
					{
						methods[i].invoke(pers);
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
