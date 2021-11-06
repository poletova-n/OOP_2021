public class MyClass {
    @MyAnnotation(2)
    private void firstMethod() {
        System.out.println("first");
    }

    @MyAnnotation(2)
    private void secondMethod() {
        System.out.println("second");
    }

    @MyAnnotation(1)
    private void thirdMethod() {
        System.out.println("third");
    }

    @MyAnnotation(1)
    private void fourthMethod() {
        System.out.println("fourth");
    }
}
