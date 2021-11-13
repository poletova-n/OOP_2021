package lab4;

public class Example {
    @Annotation(value = 4)
    private void func1(){
        System.out.println("h4");
    };
    @Annotation(value = 3)
    private void func2(){
        System.out.println("h3");
    };
    @Annotation(value = 2)
    private void func3(){
        System.out.println("h2");
    };
    @Annotation
    private void func4(){
        System.out.println("h1");
    };
}
