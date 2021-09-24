package lab2;

import lab2.exceptions.*;

import java.io.*;
import java.util.Arrays;

public class Matrix {
    int N;
    double[][] matrix;

    public Matrix(String filePath) {
        readFile(filePath);
        fillMatrix();
    }

    private void readFile(String filePath) {
        try{
            File matrixSize = new File(filePath);
            if(!matrixSize.exists()){
                throw new FileNotExist("Program failed, file does not exist!");
            }
        } catch (FileNotExist e){
            e.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            N = Integer.parseInt(br.readLine());
            if (N > 1000000){
                throw new WrongSize("Program failed, N is greater than a million!");
            }
        } catch (NumberFormatException | WrongSize | IOException e) {
            e.printStackTrace();
        }
    }

    public void printFile(String filePath) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(String.valueOf(matrix[i][j]));
                    bw.write("   ");
                }
                bw.write("\n");
            }
            bw.write("\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillMatrix() {
        double[][] curMatrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double temp = Math.round((Math.random() * (N * 2)) - N);
                curMatrix[i][j] = temp;
            }
        }
        matrix = Arrays.copyOf(curMatrix, N);
    }

    private double sumNeighbors(int i, int j) {
        double curSum = 0;
        if (i - 1 >= 0){
            curSum += matrix[i - 1][j];
        }
        if (i + 1 <= N - 1){
            curSum += matrix[i + 1][j];
        }
        if (j - 1 >= 0){
            curSum += matrix[i][j - 1];
        }
        if (j + 1 <= N - 1){
            curSum += matrix[i][j + 1];
        }
        return curSum;
    }

    public void divideElements() {
        double[][] curMatrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double curSum = sumNeighbors(i, j);
                try{
                    if(curSum == 0){
                        throw new DivisionByZero("Program failed, element is divisible by zero!");
                    }else{
                        curMatrix[i][j] = matrix[i][j] / curSum;
                    }
                } catch (DivisionByZero e){
                    curMatrix[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        matrix = Arrays.copyOf(curMatrix, N);
    }

    public void rotateMatrix() {
        double[][] curMatrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                curMatrix[i][j] = matrix[j][N - i - 1];
            }
        }
        matrix = Arrays.copyOf(curMatrix, N);
    }

    public void printMatrix() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
