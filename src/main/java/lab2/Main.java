package lab2;

import lab2.execptions.*;

public class Main {
    public static void main(String[] args) throws FileNotExist, IllegalValue
    {
        Matrix matrix = new Matrix("/D:/path/input.txt");
        matrix.printMatrix("/D:/path/output.txt");

        for (int i = 0; i < 3; i++)
        {
            matrix.makeIteration();
            matrix.printMatrix("/D:/path/output.txt");
        }

        System.out.println("Matrix printed in output.txt");
    }
}