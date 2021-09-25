package lab2;

import lab2.exceptions.*;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private int size;
    private double[][] array;

    Matrix(String path) throws FileNotFound, InvalidSize {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFound("Error, file doesn't exist");
            }
        }
        catch (FileNotFound e) {
            e.printStackTrace();
        }
        try(Scanner input = new Scanner(new File(path))){
            size = input.nextInt();
            if ((size > 1000000) | (size <= 0)){
                throw new InvalidSize("Error, invalid size");
            }
        }
        catch (InvalidSize | IOException e) {
            e.printStackTrace();
        }

        array = new double[size][size];
        setRandom();
    }

    private void setRandom() {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                double elem = Math.round((Math.random() * (size * 2)) - size);
                array[i][j] = elem;
            }
        }
    }

    public void rotate90Degrees() {

        double[][] tempArray = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempArray[i][j] = array[j][size - i - 1];
            }
        }
        array = Arrays.copyOf(tempArray, size);
    }

    private int getSumOfNeighbors(int i, int j) {
        int tempSum = 0;

        if (i - 1 >= 0) {
            tempSum += array[i - 1][j];
        }
        if (i + 1 <= size - 1) {
            tempSum += array[i + 1][j];
        }
        if (j - 1 >= 0) {
            tempSum += array[i][j - 1];
        }
        if (j + 1 <= size - 1) {
            tempSum += array[i][j + 1];
        }

        return tempSum;
    }

    public void divideElem() {
        double[][] tempArray = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = getSumOfNeighbors(i, j);

                try {
                    if (sum == 0) {
                        throw new DivisionByZero("Error, division by zero");
                    }

                    tempArray[i][j] = array[i][j] / sum;

                }
                catch (DivisionByZero ex) {
                    tempArray[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        array = Arrays.copyOf(tempArray, size);
    }

    public void printToFile(String path) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    writer.append(String.format("%.1f", array[i][j]));
                    writer.append(" ");
                }
                writer.append('\n');
            }
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//        File file = new File("out.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        FileWriter output = new FileWriter(file);
//        for (int i = 0; i < size; i++)
//        {
//            for (int j = 0; j < size; j++)
//            {
//                output.append(String.format("%.6f", array[i][j]));
//                output.append(" ");
//            }
//
//            output.append('\n');
//        }
//
//        output.append('\n');
//        output.close();