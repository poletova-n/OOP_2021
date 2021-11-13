package lab4;

public class ExampleClass {

    @Value
    private void helloWorld(){
        System.out.println("Hello world!");
    }

    @Value(data = 2)
    private void longLive(){
        System.out.println("Long live!");
    }

    @Value(data = 3)
    private void goodbyeWorld(){
        System.out.println("See you soon!");
    }
}
