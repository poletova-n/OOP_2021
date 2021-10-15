package lab2;

import lab2.exceptions.DivisionByZero;
import lab2.exceptions.FileNotExist;
import lab2.exceptions.WrongSize;

import java.io.*;
import java.util.Scanner;

public class Matrix {
    private int size;
    private double[][] matrix;

    Matrix(String path) throws FileNotExist, WrongSize, FileNotFoundException {
        try {
            File file = new File(path);
            if (!file.exists()){
                throw new FileNotExist("Error: file not exist!");
            }
        }
        catch (FileNotExist exception) {
            exception.printStackTrace();
        }
        try (Scanner in = new Scanner(new File(path))){
            size = in.nextInt();
            if ((size <= 0) | (size > 1000000)){
                throw new WrongSize("Error: wrong size!");
            }
        }
        catch (WrongSize | IOException exception){
            exception.printStackTrace();
        }

        matrix = new double[size][size];
        setRandom();
    }

    public double[][] getMatrix(){
        return matrix;
    }

    private void setRandom() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.random() * (2 * size) - size;
            }
        }
    }

    public void turn90() {

        double[][] temp = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = matrix[j][size - 1 - i];
            }
        }
        matrix = temp;
    }

    public int getSum(int i, int j){

        int temp = 0;

        if (i - 1 >= 0) {
            temp += matrix[i - 1][j];
        }
        if (i + 1 <= size - 1) {
            temp += matrix[i + 1][j];
        }
        if (j - 1 >= 0) {
            temp += matrix[i][j - 1];
        }
        if (j + 1 <= size - 1) {
            temp += matrix[i][j + 1];
        }

        return temp;
    }

    public void Division(){

        double[][] temp = new double[size][size];
        int sum;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum = getSum(i, j);
                try{
                    if (sum == 0) {
                        throw new DivisionByZero("Error: division by zero!");
                    }
                    matrix[i][j] = matrix[i][j]/sum;
                }
                catch (DivisionByZero exception){
                    matrix[i][j] = Double.POSITIVE_INFINITY;
                    exception.printStackTrace();
                }
            }
        }
    }

    public void action90(){
        turn90();
        Division();
    }
    public void action180(){
        turn90();
        turn90();
        Division();
    }
    public void action270(){
        turn90();
        turn90();
        turn90();
        Division();
    }


    public void printMatrix(String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    writer.write(String.format("%.1f", matrix[i][j]));
                    writer.write(" ");
                }
                System.out.println();
            }
            System.out.println();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
