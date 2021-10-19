package lab4;

public class PrivatMethodsClass {

    private void met1() {
        System.out.println("met1");
    }
    @CallNTimes(5)
    private void met2() {
        System.out.println("met2");
    }
    private void met3() {
        System.out.println("met3");
    }
    @CallNTimes(7)
    private void met4() {
        System.out.println("met4");
    }
}
