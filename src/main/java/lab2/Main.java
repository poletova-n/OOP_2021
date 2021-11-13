package lab2;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args)
    {
        Matrix matrix = new Matrix("C:/Users/denag/IdeaProjects/OOP_2021/src/main/java/lab2/input.txt");
        matrix.printMatrix("C:/Users/denag/IdeaProjects/OOP_2021/src/main/java/lab2/output.txt");
        for (int i = 0; i < 3; i++)
        {
            matrix.rotate();
            matrix.subtractAndDivide();
            matrix.printMatrix("C:/Users/denag/IdeaProjects/OOP_2021/src/main/java/lab2/output.txt");
        }
    }
}
