package lab3;

import lab3.exceptions.*;

public class Main {
    public static void main(String[] args) {
        try {
            
            Queue.selectClass();

        }
        catch (QueueUnderflow | QueueOverflow | ClassCastException e){
            System.out.println(e.getMessage());
        }
    }
}