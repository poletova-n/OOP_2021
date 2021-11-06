package lab4;

public class Human
{
    @MyAnnotation(param = 1)
    private void walk()
    {
        System.out.println("Walk for a bit ");
    }

    @MyAnnotation()
    private void sleep()
    {
        System.out.println("Zzzzzz...zzzzz ");
    }

    @MyAnnotation(param = 3)
    private void swim()
    {
        System.out.println("I'm drowning... ");
    }

    @MyAnnotation(param = 4)
    private void fly()
    {
        System.out.println("Wtf fly? ");
    }
}
