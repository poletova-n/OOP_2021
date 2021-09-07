package lab1;

public class Main
{
	public static void main(String[] args)
	{
		Hero pers = new Hero();

		pers.setTypeOfActivity(new Fly());
		pers.moveOut(new Point(4, 5));
		
		pers.setTypeOfActivity(new Swim());
		pers.moveOut(new Point(2, 1));

		pers.setTypeOfActivity(new Walk());
		pers.moveOut(new Point(-33, 9));

		pers.setTypeOfActivity(new RideHorse());
		pers.moveOut(new Point(111, -4));

		pers.setTypeOfActivity(new Fly());
		pers.moveOut(new Point(10, 0));
	}
}