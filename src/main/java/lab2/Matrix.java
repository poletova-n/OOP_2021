package lab2;
import lab2.exceptions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private double[][] matrix;
    private int size;

    public Matrix(String path)
    {
        try
        {
            File input = new File(path);
            if (!input.exists()){
                throw new FileNotFound("This file is not found!");
            }
            if (input.length() == 0){
                throw new EmptyFile("This file is empty!");
            }
            Scanner inputNumber = new Scanner(new File(path));
            size = inputNumber.nextInt();
            if (size > 1000000 | size <= 0){
                throw new InvalidMatrixSize("Incorrect size!");
            }
        }
        catch (FileNotFound | InvalidMatrixSize | EmptyFile e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        matrix = new double[size][size];
    }

    public void fillRandom()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.random() * (size * 2) - size;
            }
        }
    }

    public void rotateNinety()
    {
        double[][] temp = new double[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                temp[i][j] = matrix[j][size - 1 - i];
            }
        }
        matrix = Arrays.copyOf(temp, size);
    }

    public void divideSumNeighbors()
    {
        double sum = 0.0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if ( j + 1 <= size - 1){
                    sum += matrix[i][j+1];
                }
                if ( i + 1 <= size - 1){
                    sum += matrix[i+1][j];
                }
                if ( j - 1 >= 0){
                    sum += matrix[i][j-1];
                }
                if ( i - 1 >= 0){
                    sum += matrix[i-1][j];
                }
                try {
                    if (sum == 0){
                        throw new DivisionByZero("Division by zero is not correct!");
                    }
                    matrix[i][j] = matrix[i][j]/sum;
                }
                catch (DivisionByZero e){
                    matrix[i][j] = Double.POSITIVE_INFINITY;
                    e.printStackTrace();
                }
            }
        }
    }

    public void rotateAndDivide()
    {
        rotateNinety();
        divideSumNeighbors();
    }

    public void printMatrix(String path)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    writer.append(String.valueOf(matrix[i][j]));
                    writer.append(" ");
                }
                writer.append('\n');
            }
            writer.append("\n");
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
