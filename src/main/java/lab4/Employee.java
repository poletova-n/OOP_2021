package lab4;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface HowMuchHowMany{
    byte value() default 0;
}

public class Employee {
    private static int counterId = 0;

    private final int id;
    private final String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id = ++counterId;
    }

    public String getName() {
        return name;
    }
    public void   setSalary(double salary) {
        this.salary = salary;
    }

    @HowMuchHowMany(10)
    private void sayHi(){
        System.out.println("Hi, I am " + name + ".");
    }
    @HowMuchHowMany(10)
    private double getSalary(int hours) {
        return salary * hours;
    }
    @HowMuchHowMany(5)
    private String toJsonFormat() {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        sb.append("\t \"id\": \"").append(id).append("\",\n");
        sb.append("\t \"name\": \"").append(name).append("\",\n");
        sb.append("\t \"salary\": \"").append(salary).append("\",\n");
        sb.append("}");
        return  sb.toString();
    }
    @HowMuchHowMany(1)
    private void work(String[] schedule) {
        sayHi();
        int counter = 0;
        for (String task: schedule){
            counter++;
            System.out.println("Employee's id: " + id + ". Did " + "task "+ counter+ " " + "\""+task+"\".");
        }
        System.out.println("Good night!");
    }
}