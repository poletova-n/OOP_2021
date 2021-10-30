package lab4;

public class Human {

    @privateExec(execCount = 2)
    private void sayHi(){
        System.out.println("Hello, I'm a human!");
    }

    @privateExec(execCount = 4)
    private void walk(){
        System.out.println("Human is walking!");
    }

    @privateExec(execCount = 3)
    private void sitDown(){
        System.out.println("Human took a seat!");
    }

    @privateExec
    private void talk(){
        System.out.println("Human is talking something...");
    }

}
