package lab4;

public class LazyStudent {
    @MyAnnotation(count = 1)
    private void GoTOUniversity(){
        System.out.println("Brah, I will stay at home!");
    }

    @MyAnnotation(count = 2)
    private void DoLaboratoryWork(){
        System.out.println("Nah, better play some games :)))");
    }

    @MyAnnotation(count = 3)
    private void CheckDeadlines(){
        System.out.println("Damn, it doesn't look good :((");
    }

    @MyAnnotation(count = 4)
    private void TimeToDoSomething(){
        System.out.println("Why i'm always leaving this to point of no return");
    }

    private void DoNothing(){
        System.out.println("You can't see this");
    }
}
