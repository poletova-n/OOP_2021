package lab4;

public class Person 
{
	@MyAnnotation(param = 3)
	private void eat() 
	{
		System.out.println("He who doesn't work, shall eat!");
	}
	
	@MyAnnotation(param = 4)
	private void code()
	{
		System.out.println("Ah shit, here we go again...");
	}
	
	@MyAnnotation()
	private void sleep() 
	{
		System.out.println("A good sleep is the key to beauty.");
	}
	
	private void walk() 
	{
		System.out.println("I Believe I Can Walk");
	}
}

