package lab4;

public class Function {
    @Counter(Counter = 1)
    private void firstFunction(){
        System.out.println("This function will be called once");
    }

    @Counter(Counter = 2)
    private void secondFunction(){
        System.out.println("And this one 2 times");
    }

    @Counter(Counter = 3)
    private void thirdFunction(){
        System.out.println("This function will appear 3 times");
    }
}