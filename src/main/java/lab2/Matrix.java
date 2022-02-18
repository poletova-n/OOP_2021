package lab2;

import lab2.exceptions.DivisionByZero;
import lab2.exceptions.FileNotFound;
import lab2.exceptions.InvalidMatrixSize;

import java.io.*;

public class Matrix {

    private int N;
    private double[][] matrix;

    public Matrix(String fileName)
    {
        readMatrixSize(fileName);
        fillMatrix();
    }


    private void  readMatrixSize(String fileName) {


        try {
            File tempFile = new File(fileName);
            if (!tempFile.exists()) {
                throw new FileNotFound("Cant find the file!");
            }
        } catch (FileNotFound e) {
            e.printStackTrace();
        }


        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            N = Integer.parseInt(br.readLine());

            if (N > 1000000 | N <= 0)
            {
                throw new InvalidMatrixSize("Incorrect matrix size!");
            }

        } catch (NumberFormatException | InvalidMatrixSize | IOException e) {
            e.printStackTrace();
        }

    }

    private void fillMatrix() {
        matrix = new double[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double rand = Math.round((Math.random() * (N  * 2)) - N);

                matrix[i][j] =  rand;
            }
        }



    }

    public void rotate() {
        double[][] mRotated = new double[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mRotated[i][j] = matrix[j][N - i - 1];
            }
        }


        matrix = mRotated;
    }

    public void divideSumNeighbors()
    {
        double sum = 0.0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if ( j + 1 <= N - 1){
                    sum += matrix[i][j+1];
                }
                if ( i + 1 <= N - 1){
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
                        throw new DivisionByZero("Division by zero!");
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

    public void writeToFile(String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    writer.append(String.format("%.6f", matrix[i][j]));
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